import { LOCALES } from './consts'

/**
 * pass supported locales like this: 'en-US,es-US,he-IL'
 * this list will apply only for tests using supported locales. the rest of the tests will run with the locale
 * defined for them in initMockConfig.
 */

const supportedLocales = process.env.LOCALES
    ? process.env.LOCALES.split(',')
    : [LOCALES.EN_US]

export default supportedLocales
