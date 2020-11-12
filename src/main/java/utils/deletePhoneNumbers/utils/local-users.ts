import * as userPool from './userPool'

async function main() {
    const mode: string = process.argv[2]
    const index: number = Number.parseInt(process.argv[3])
    console.log('mode and index', mode, index)
    if (mode === 'claim') {
        const user = await userPool.claimUser()
        console.log('You have claimed user', user)
        console.log('Please run your tests with environment variable:')
        console.log(`E2E_USER=${user.index} detox test...`)
        console.log('Do not forget to delete user after you are done with:')
        console.log(`yarn e2e:removeuser ${user.index}`)
    } else if (mode === 'remove') {
        await userPool.deleteUser(userPool.userFromIndex(index))
    }
}

main().catch(e => console.log('error', e))
