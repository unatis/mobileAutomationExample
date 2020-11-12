import * as userPool from './userPool'

async function main() {
    const size = userPool.size()

    for (let i = 0; i < size; i++) {
        const user = userPool.getUserRaw(i)
        await userPool.deleteUser(user)
        // await userPool.registerUser(user)
    }
}

main().catch(e => console.log('error', e))
