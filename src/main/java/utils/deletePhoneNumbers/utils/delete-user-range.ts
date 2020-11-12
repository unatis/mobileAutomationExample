import _ from 'lodash'
import { E2EUser, userFromIndex, deleteUser } from './userPool'
import { kangpyURL, identityURL } from './api'

let RANGE_MIN: number
let RANGE_MAX: number

if (
    typeof process.env.USER_RANGE_MIN === 'string' &&
    typeof process.env.USER_RANGE_MAX === 'string'
) {
    RANGE_MIN = parseInt(process.env.USER_RANGE_MIN)
    RANGE_MAX = parseInt(process.env.USER_RANGE_MAX)
} else {
    throw 'Please specify USER_RANGE_MIN and USER_RANGE_MAX environment variables'
}

async function main() {
    const users: E2EUser[] = _.range(RANGE_MIN, RANGE_MAX).map(index => {
        return userFromIndex(index)
    })

    console.log(
        `Environment: ${JSON.stringify({
            K_IDENTITY_API_URL: identityURL(),
            K_API_URL: kangpyURL(),
        })}`,
    )

    for (const user of users) {
        await deleteUser(user)
        console.log(`Deleted user ${user.code}`)
    }
}

main().catch(e => console.log('error', e))
