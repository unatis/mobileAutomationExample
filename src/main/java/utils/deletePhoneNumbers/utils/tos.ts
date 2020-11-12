import { isElementVisible, tapWhenReady } from './detoxUtils/elements'
import { acceptButton } from './accessors/tos'

export const continueTOSIfThere = async () => {
    const isWaitingOnTOSAccept = await isElementVisible(acceptButton())
    if (isWaitingOnTOSAccept) {
        await tapWhenReady(acceptButton())
        await device.takeScreenshot(
            process.env.CIRCLE_NODE_INDEX + '_login_001_after_accept_TOS',
        )
    }
}
