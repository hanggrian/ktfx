package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import ktfx.jfoenix.test.BaseJFXAutoCompletePopupTest

class JfxAutoCompletePopupTest : BaseJFXAutoCompletePopupTest() {
    override fun <E> JFXAutoCompletePopup<E>.callSelectionHandler(
        action: (JFXAutoCompleteEvent<E>) -> Unit
    ): Unit = selectionHandler(action)
}
