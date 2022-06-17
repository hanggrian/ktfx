package ktfx.coroutines

import javafx.event.Event
import javafx.stage.BasePopupWindowTest
import javafx.stage.PopupWindow
import kotlinx.coroutines.Dispatchers

class PopupWindowTest : BasePopupWindowTest() {

    override fun PopupWindow.callOnAutoHide(action: (Event) -> Unit) =
        onAutoHide(Dispatchers.Unconfined) { action(it) }
}
