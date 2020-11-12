import _ from 'lodash'
//@ts-ignore
import fetch from 'node-fetch'
import { LOCALES } from './consts'
import { identityURL, kangpyURL } from './api'
import poorMansLogging from './poor-mans-logging'

export interface E2EUser {
    phone: string
    code: string
    index: number
    email: string
}

const RANGE_MIN = 9000
const RANGE_MAX = 9999
let CURRENT_USER_KPACCESS: string | null = null
let CURRENT_USER_KPREFRESH: string | null = null

export function userFromIndex(index: number): E2EUser {
    const code = String(index).padStart(6, '0')
    return {
        phone: `+972540${code}`,
        code,
        email: getRandomTestEmail(),
        index,
    }
}

const users: E2EUser[] = _.range(RANGE_MIN, RANGE_MAX).map(index => {
    return userFromIndex(index)
})

export function size() {
    return users.length
}

export function getUserRaw(id: number): E2EUser {
    return users[id]
}

export async function deleteUser(user: E2EUser) {
    try {
        const phoneAvailable = await isPhoneAvailable(user.phone)
        if (phoneAvailable) {
            return
        }
        await handleDelete(user)
    } catch (error) {
        poorMansLogging(
            `error while trying to delete user ${user.phone}`,
            error,
        )
    }
}

async function postData(
    url: string,
    data: object,
    extraHeaders?: object,
    method = 'POST',
) {
    try {
        const response = await fetch(url, {
            method,
            mode: 'cors',
            //@ts-ignore
            cache: 'no-cache',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/json; charset=utf-8',
                ...extraHeaders,
            },
            redirect: 'follow',
            referrer: 'no-referrer',
            body: JSON.stringify(data),
            timestamp: new Date().getTime(),
        })
        return response.json()
    } catch (error) {
        console.error(`Fetch Error =\n`, error)
    }
}

async function deleteData(url: string, headers: object) {
    try {
        const response = await fetch(url, {
            method: 'DELETE',
            mode: 'cors',
            // @ts-ignore
            cache: 'no-cache',
            credentials: 'same-origin',
            headers: headers,
            redirect: 'follow',
            referrer: 'no-referrer',
            timestamp: new Date().getTime(),
        })
        return response.json()
    } catch (error) {
        console.error(`Fetch Error =\n`, error)
    }
}

async function deleteIdentityForToken(accessToken: string) {
    const apiURL = identityURL() + '/api/v1/users/authenticated'
    const json = await deleteData(apiURL, {
        Authorization: accessToken,
    })
    poorMansLogging('user deleted successfully', json)
}

export async function registerUser(user: E2EUser, locale = LOCALES.EN_US) {
    const { phone, code } = user
    const kangpyCreateUserURL = kangpyURL() + '/users'
    const kangpyCreateResult = await postData(kangpyCreateUserURL, {
        install_id: 'abcdef',
        deviceToken: 'abcdef',
        name: `Pickle Rick ${code}`,
        profile: {
            geo: {
                region: 'ID',
                city: 'Boise',
                country: 'US',
                lat: 43.6007847,
                lon: -116.3039377,
            },
        },
        settings: { locale, unit_system: 'english' },
        is_bot: true,
    })
    const {
        access_token: kpaccess,
        refresh_token: kprefresh,
    } = kangpyCreateResult
    CURRENT_USER_KPACCESS = kpaccess
    CURRENT_USER_KPREFRESH = kprefresh

    poorMansLogging('created user', user.phone, kangpyCreateResult._id)
    if (kangpyCreateResult.is_error) {
        throw kangpyCreateResult
    }
    const patch = kangpyURL() + '/users/me'
    const kangpyPatch = await postData(
        patch,
        {
            profile: {
                geo: {
                    region: 'ID',
                    city: 'Boise',
                    country: 'US',
                    lat: 43.6007847,
                    lon: -116.3039377,
                },
                dob: "1990-01-01'T'00:00:00.0000000",
                gender: 'male',
            },
            settings: { locale, unit_system: 'english' },
        },
        {
            Authorization: kpaccess,
        },
        'PATCH',
    )
    if (kangpyPatch.is_error) {
        throw kangpyPatch
    }
    const client_id = 'kang_app'
    const identityCreateUserURL = identityURL() + '/api/v1/users'
    const identityCreateResult = await postData(identityCreateUserURL, {
        client: {
            client_id,
        },
    })
    if (identityCreateResult.is_error) {
        throw identityCreateResult
    }
    const associationToken = identityCreateResult.token
    const kangpyAssociateURL =
        kangpyURL() + '/users/authenticated/associate_identity'
    const assocResult = await postData(
        kangpyAssociateURL,
        { token: associationToken },
        {
            Authorization: kpaccess,
        },
    )
    if (assocResult.is_error) {
        throw assocResult
    }
    const idToken = assocResult.access_token
    const triggerPhoneURL =
        identityURL() + '/api/v1/users/authenticated/login_phone'
    const triggerPhoneResult = await postData(
        triggerPhoneURL,
        {
            login_phone: phone,
            locale,
            gender: 'male',
        },
        {
            Authorization: idToken,
        },
    )
    if (triggerPhoneResult.is_error) {
        throw triggerPhoneResult
    }
    const phoneConfirmURL =
        identityURL() + '/api/v1/users/authenticated/login_phone_confirm'
    const phoneConfirmResult = await postData(
        phoneConfirmURL,
        {
            login_phone: phone,
            code: code,
            locale: 'en-US',
            gender: 'male',
        },
        {
            Authorization: idToken,
        },
    )
    if (phoneConfirmResult.is_error) {
        throw phoneConfirmResult
    }
    return phoneConfirmResult
}

async function revokeKangpyAccessToken() {
    const apiURL = kangpyURL() + '/users/tokens/access_revoke'
    const json = await postData(
        apiURL,
        {},
        {
            Authorization: CURRENT_USER_KPACCESS,
        },
    )
    CURRENT_USER_KPACCESS = null
    poorMansLogging('revoke access token response ', json)
}

async function revokeKangpyRefreshToken() {
    const apiURL = kangpyURL() + '/users/tokens/refresh_revoke'
    const json = await postData(
        apiURL,
        {},
        {
            Authorization: CURRENT_USER_KPREFRESH,
        },
    )
    CURRENT_USER_KPREFRESH = null
    poorMansLogging('revoke refresh token response ', json)
}

async function getTokensAndDeleteIdentity(generationToken: string) {
    const apiURL = identityURL() + '/api/v1/exchange_tokens'
    const json = await postData(
        apiURL,
        {
            client: {
                client_id: 'kang_app',
                client_secret: 'the most secretive secret of kang app',
            },
        },
        {
            Authorization: generationToken,
        },
    )
    const accessToken = json.tokens.access_token
    await deleteIdentityForToken(accessToken)
}

async function isPhoneAvailable(phone: string): Promise<boolean> {
    const apiURL = identityURL() + '/api/v1/login_phone'
    return new Promise(async resolve => {
        const res = await postData(apiURL, {
            login_phone: phone,
            locale: LOCALES.EN_US,
            gender: 'male',
            client_id: 'kang_app',
        })
        poorMansLogging('response', res)
        if (res.error === 'not_valid') {
            poorMansLogging('Phone is available!')
            resolve(true)
        } else {
            poorMansLogging('Phone is not available!')
            resolve(false)
        }
    })
}

async function isEmailAvailable(email: string): Promise<boolean> {
    const apiURL = identityURL() + '/api/v1/login_email'
    return new Promise(async resolve => {
        const res = await postData(apiURL, {
            login_email: email,
            locale: 'he-IL',
            gender: 'female',
            client_id: 'kang_app',
        })
        poorMansLogging('response', res)
        if (res.error === 'not_valid') {
            poorMansLogging('Email is available!')
            resolve(true)
        } else {
            poorMansLogging('Email is not available!')
            resolve(false)
        }
    })
}

async function handleDelete(user: E2EUser) {
    const apiURL = identityURL() + '/api/v1/login'
    const json = await postData(apiURL, {
        login_phone: user.phone,
        code: user.code,
        client_id: 'kang_app',
    })
    if (json.error) {
        if (json.error === 'not_valid') {
            poorMansLogging(
                `wrong code ${user.code} for user with number ${user.phone}`,
                json,
            )
        } else {
            poorMansLogging('error json', json)
        }
    } else {
        await revokeKangpyRefreshToken()
        await revokeKangpyAccessToken()
        await getTokensAndDeleteIdentity(json.token)
    }
}

export async function findEmptyUser(): Promise<E2EUser> {
    for (let i = 1; i < 10; i++) {
        const randomNumber = _.random(RANGE_MIN, RANGE_MAX - 1)
        const user = userFromIndex(randomNumber)
        poorMansLogging('Trying user: ', user)
        const [phoneAvailable, emailAvailable] = await Promise.all([
            isPhoneAvailable(user.phone),
            isEmailAvailable(user.phone),
        ])
        if (phoneAvailable && emailAvailable) {
            return user
        }
    }
    throw new Error(
        `Tried 10 times but could not find free user in range [${RANGE_MIN}:${RANGE_MAX})`,
    )
}

export function getRandomTestEmail() {
    return 'a' + Math.round(Math.random() * 100000) + '@a.com'
}

export async function claimUser(
    locale: string = LOCALES.EN_US,
): Promise<E2EUser> {
    if (process.env.E2E_USER) {
        poorMansLogging('using specific user:', process.env.E2E_USER)
        return userFromIndex(Number.parseInt(process.env.E2E_USER))
    } else {
        poorMansLogging('looking for a random user')
        const user = await findEmptyUser()
        await registerUser(user, locale)
        return user
    }
}
