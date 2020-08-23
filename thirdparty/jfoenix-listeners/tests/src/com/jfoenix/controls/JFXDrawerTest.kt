package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import ktfx.jfoenix.test.BaseJFXDrawerTest

class JFXDrawerTest : BaseJFXDrawerTest() {

    override fun JFXDrawer.callOnDrawerClosed(action: (JFXDrawerEvent) -> Unit) = onDrawerClosed(action)
    override fun JFXDrawer.callOnDrawerClosing(action: (JFXDrawerEvent) -> Unit) = onDrawerClosing(action)
    override fun JFXDrawer.callOnDrawerOpened(action: (JFXDrawerEvent) -> Unit) = onDrawerOpened(action)
    override fun JFXDrawer.callOnDrawerOpening(action: (JFXDrawerEvent) -> Unit) = onDrawerOpening(action)
}