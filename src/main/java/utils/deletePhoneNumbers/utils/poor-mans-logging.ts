const hasLogs =
    process.env.CI === 'true' || process.env.E2E_EXTRA_LOGS === 'true'
console.log('has logs?', hasLogs, process.env.CI, process.env.E2E_EXTRA_LOGS)

export default function poorMansLogging(...args: any[]) {
    if (!hasLogs) {
        return
    }
    console.log(...args)
}
