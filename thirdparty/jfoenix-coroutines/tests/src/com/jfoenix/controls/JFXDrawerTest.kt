package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXDrawerEvent
import kotlinx.coroutines.Dispatchers
import ktfx.jfoenix.test.BaseJFXDrawerTest

class JFXDrawerTest : BaseJFXDrawerTest() {

    override fun JFXDrawer.callOnDrawerClosed(action: (JFXDrawerEvent) -> Unit) =
        onDrawerClosed(Dispatchers.Unconfined) { action(it) }

    override fun JFXDrawer.callOnDrawerClosing(action: (JFXDrawerEvent) -> Unit) =
        onDrawerClosing(Dispatchers.Unconfined) { action(it) }

    override fun JFXDrawer.callOnDrawerOpened(action: (JFXDrawerEvent) -> Unit) =
        onDrawerOpened(Dispatchers.Unconfined) { action(it) }

    override fun JFXDrawer.callOnDrawerOpening(action: (JFXDrawerEvent) -> Unit) =
        onDrawerOpening(Dispatchers.Unconfined) { action(it) }
}