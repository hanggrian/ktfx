package ktfx.test

import javafx.scene.control.Dialog
import javafx.scene.input.KeyCode
import javafx.stage.Stage
import org.testfx.api.FxRobot
import org.testfx.framework.junit.ApplicationTest

/**
 * Showing dialogs with [Dialog.showAndWait] forces the test to wait for user input.
 * Instead, quickly hit enter whenever dialogs are showing.
 */
open class BaseDialogTest : ApplicationTest() {

    override fun start(stage: Stage) {
        stage.testScene<Dialog<*>>()
    }

    fun FxRobot.closeOnShow(dialog: Dialog<*>) = dialog.setOnShown { push(KeyCode.ENTER) }
}