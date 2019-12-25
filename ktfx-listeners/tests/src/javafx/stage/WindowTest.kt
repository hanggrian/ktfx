package ktfx.listeners

import javafx.stage.BaseWindowTest
import javafx.stage.Window
import javafx.stage.WindowEvent

class WindowTest : BaseWindowTest() {

    override fun Window.callOnCloseRequest(action: (WindowEvent) -> Unit) = onCloseRequest(action)
    override fun Window.callOnShowing(action: (WindowEvent) -> Unit) = onShowing(action)
    override fun Window.callOnShown(action: (WindowEvent) -> Unit) = onShown(action)
    override fun Window.callOnHiding(action: (WindowEvent) -> Unit) = onHiding(action)
    override fun Window.callOnHidden(action: (WindowEvent) -> Unit) = onHidden(action)
}