export const DEFAULT_TIMEOUT = 30000
export const HOOK_STEPS_TIMEOUT = 2 * 60 * 1000
export const HOOK_START_TIMEOUT = 20 * 60 * 1000
export const SEARCH_ANIMATION_VISIBLE = 5 * 1000

export const LOCALES = {
    HE_IL: 'he-IL',
    EN_US: 'en-US',
    ES_US: 'es-US',
}

export const IL_LOCATION = {
    region: 'HA',
    city: 'Haifa',
    country: 'IL',
    lat: 32.830360412597656,
    lon: 34.97433853149414,
}

export const US_LOCATION = {
    region: 'ID',
    city: 'Boise',
    country: 'US',
    lat: 43.6007847,
    lon: -116.3039377,
}

export const SOME_WEIRD_LOCATION = {
    region: 'xxxx',
    city: 'xxxx',
    country: 'xxx',
    lat: 1000,
    lon: 1000,
}

export enum contextTypes {
    GLOBAL = 'global',
    ONBOARDING = 'onboarding',
    MACCABI_ONBOARDING = 'mcb_onboarding',
    MACCABI_LOGIN = 'mcb_login',
    LOGIN = 'login',
    ACCOUNT = 'account',
    HOME = 'home',
    WELCOME = 'welcome',
    KMD = 'kmd',
    CHAT = 'healthDialog',
    PTT = 'ptt',
    ME = 'me',
    IRR = 'irr',
    LEGACY_PRESHARE = 'preshare',
    PAYMENTS = 'payments',
}
