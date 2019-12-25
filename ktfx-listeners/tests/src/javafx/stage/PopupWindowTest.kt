package ktfx.listeners

import javafx.event.Event
import javafx.stage.BasePopupWindowTest
import javafx.stage.PopupWindow

class PopupWindowTest : BasePopupWindowTest() {

    override fun PopupWindow.callOnAutoHide(action: (Event) -> Unit) = onAutoHide(action)
}