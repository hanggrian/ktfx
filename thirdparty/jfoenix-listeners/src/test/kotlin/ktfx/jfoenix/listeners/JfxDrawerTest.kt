package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import ktfx.jfoenix.test.BaseJFXDrawerTest

class JfxDrawerTest : BaseJFXDrawerTest() {
    override fun JFXDrawer.callOnDrawerClosed(action: (JFXDrawerEvent) -> Unit): Unit =
        onDrawerClosed(action)

    override fun JFXDrawer.callOnDrawerClosing(action: (JFXDrawerEvent) -> Unit): Unit =
        onDrawerClosing(action)

    override fun JFXDrawer.callOnDrawerOpened(action: (JFXDrawerEvent) -> Unit): Unit =
        onDrawerOpened(action)

    override fun JFXDrawer.callOnDrawerOpening(action: (JFXDrawerEvent) -> Unit): Unit =
        onDrawerOpening(action)
}
