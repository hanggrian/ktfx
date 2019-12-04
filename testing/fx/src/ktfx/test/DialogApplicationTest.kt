package ktfx.test

import javafx.scene.control.Dialog
import javafx.scene.input.KeyCode
import org.testfx.framework.junit.ApplicationTest

/**
 * Showing dialogs with [Dialog.showAndWait] forces the test to wait for user input.
 * Instead, quickly hit enter whenever dialogs are showing.
 */
open class DialogApplicationTest : ApplicationTest() {

    fun Dialog<*>.closeOnShow() = setOnShown { push(KeyCode.ENTER) }
}