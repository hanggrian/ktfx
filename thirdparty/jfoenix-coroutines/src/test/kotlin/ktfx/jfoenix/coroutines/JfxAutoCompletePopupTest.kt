package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import kotlinx.coroutines.Dispatchers
import ktfx.jfoenix.test.BaseJFXAutoCompletePopupTest

class JfxAutoCompletePopupTest : BaseJFXAutoCompletePopupTest() {
    override fun <E> JFXAutoCompletePopup<E>.callSelectionHandler(
        action: (JFXAutoCompleteEvent<E>) -> Unit,
    ): Unit = selectionHandler(Dispatchers.Unconfined) { action(it) }
}
