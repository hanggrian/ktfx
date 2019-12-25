package ktfx.coroutines

import javafx.stage.BaseWindowTest
import javafx.stage.Window
import javafx.stage.WindowEvent
import kotlinx.coroutines.Dispatchers

class WindowTest : BaseWindowTest() {

    override fun Window.callOnCloseRequest(action: (WindowEvent) -> Unit) =
        onCloseRequest(Dispatchers.Unconfined) { action(it) }

    override fun Window.callOnShowing(action: (WindowEvent) -> Unit) =
        onShowing(Dispatchers.Unconfined) { action(it) }

    override fun Window.callOnShown(action: (WindowEvent) -> Unit) =
        onShown(Dispatchers.Unconfined) { action(it) }

    override fun Window.callOnHiding(action: (WindowEvent) -> Unit) =
        onHiding(Dispatchers.Unconfined) { action(it) }

    override fun Window.callOnHidden(action: (WindowEvent) -> Unit) =
        onHidden(Dispatchers.Unconfined) { action(it) }
}