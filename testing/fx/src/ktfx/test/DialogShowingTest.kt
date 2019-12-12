package ktfx.test

import javafx.scene.control.Dialog
import javafx.scene.input.KeyCode
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension

/**
 * Showing dialogs with [Dialog.showAndWait] forces the test to wait for user input.
 * Instead, quickly hit enter whenever dialogs are showing.
 */
@ExtendWith(ApplicationExtension::class)
open class DialogShowingTest {

    fun FxRobot.closeOnShow(dialog: Dialog<*>) = dialog.setOnShown { push(KeyCode.ENTER) }
}