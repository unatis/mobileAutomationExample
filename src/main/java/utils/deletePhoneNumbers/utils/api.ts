export function identityURL() {
    return (
        process.env.K_IDENTITY_API_URL ||
        'https://identity.integration.khealth.xyz'
    )
}
export function kangpyURL() {
    return process.env.K_API_URL || 'https://api.integration.khealth.xyz'
}

export function providerURL() {
    const host =
        process.env.K_PROVIDER_API_URL ||
        'https://provider.integration.khealth.xyz'
    return `${host}/api/v1`
}

export function maccabiProviderURL() {
    const host =
        process.env.K_MACCABI_PROVIDER_API_URL ||
        'https://k5c-maccabi.khealth.xyz'
    return `${host}/api/v1`
}
