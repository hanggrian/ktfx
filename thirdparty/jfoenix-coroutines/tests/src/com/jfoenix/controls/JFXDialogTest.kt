package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
import kotlinx.coroutines.Dispatchers
import ktfx.jfoenix.test.BaseJFXDialogTest

class JFXDialogTest : BaseJFXDialogTest() {

    override fun JFXDialog.callOnDialogClosed(action: (JFXDialogEvent) -> Unit) =
        onDialogClosed(Dispatchers.Unconfined) { action(it) }

    override fun JFXDialog.callOnDialogOpened(action: (JFXDialogEvent) -> Unit) =
        onDialogOpened(Dispatchers.Unconfined) { action(it) }
}
