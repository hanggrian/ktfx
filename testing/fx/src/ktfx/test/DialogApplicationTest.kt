package ktfx.test

import javafx.scene.control.Dialog
import javafx.scene.input.KeyCode
import org.testfx.framework.junit.ApplicationTest

open class DialogApplicationTest : ApplicationTest() {

    fun Dialog<*>.closeOnShow() = setOnShown { push(KeyCode.ENTER) }
}