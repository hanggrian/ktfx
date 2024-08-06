package ktfx.controlsfx.controls

import javafx.scene.control.TextField
import javafx.stage.Stage
import ktfx.layouts.scene
import ktfx.layouts.textField
import org.controlsfx.validation.ValidationSupport
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Ignore
class ValidationSupportTest : ApplicationTest() {
    private lateinit var support: ValidationSupport
    private lateinit var textField: TextField

    override fun start(stage: Stage) {
        support = ValidationSupport()
        stage.scene { textField = textField() }
        stage.show()
    }

    @Test
    fun registerEmptyValidator() {
        textField.registerEmptyValidator<String>("", support = support)
        assertEquals(1, support.registeredControls.size)
        clickOn(textField)
        assertTrue(support.isInvalid)
        write("Hello world")
        assertFalse(support.isInvalid)
    }

    @Test
    fun registerEqualsValidator() {
        textField.registerEqualsValidator("", listOf("Hello", "world"), support = support)
        assertEquals(1, support.registeredControls.size)
        clickOn(textField)
        assertTrue(support.isInvalid)
        write("Hello")
        assertFalse(support.isInvalid)
    }

    @Test
    fun registerPredicateValidator() {
        textField.registerPredicateValidator<String>("", support = support) {
            it.toIntOrNull() != null
        }
        assertEquals(1, support.registeredControls.size)
        clickOn(textField)
        assertTrue(support.isInvalid)
        write("123")
        assertFalse(support.isInvalid)
    }
}
