package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import kotlinx.coroutines.Dispatchers
import ktfx.jfoenix.test.BaseJFXDrawerTest

class JfxDrawerTest : BaseJFXDrawerTest() {
    override fun JFXDrawer.callOnDrawerClosed(action: (JFXDrawerEvent) -> Unit): Unit =
        onDrawerClosed(Dispatchers.Unconfined) { action(it) }

    override fun JFXDrawer.callOnDrawerClosing(action: (JFXDrawerEvent) -> Unit): Unit =
        onDrawerClosing(Dispatchers.Unconfined) { action(it) }

    override fun JFXDrawer.callOnDrawerOpened(action: (JFXDrawerEvent) -> Unit): Unit =
        onDrawerOpened(Dispatchers.Unconfined) { action(it) }

    override fun JFXDrawer.callOnDrawerOpening(action: (JFXDrawerEvent) -> Unit): Unit =
        onDrawerOpening(Dispatchers.Unconfined) { action(it) }
}
