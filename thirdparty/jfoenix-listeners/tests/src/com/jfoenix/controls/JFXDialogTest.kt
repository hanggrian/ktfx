package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.events.JFXDialogEvent
import ktfx.jfoenix.test.BaseJFXDialogTest

class JFXDialogTest : BaseJFXDialogTest() {

    override fun JFXDialog.callOnDialogClosed(action: (JFXDialogEvent) -> Unit) = onDialogClosed(action)
    override fun JFXDialog.callOnDialogOpened(action: (JFXDialogEvent) -> Unit) = onDialogOpened(action)
}