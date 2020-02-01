package ktfx.controlsfx.controls

import javafx.scene.control.TextField
import ktfx.test.initToolkit
import ktfx.text.buildStringConverter
import kotlin.test.BeforeTest
import kotlin.test.Test

class TextFieldsTest {
    private lateinit var field: TextField

    @BeforeTest fun start() {
        initToolkit()
        field = TextField()
    }

    @Test fun bindAutoCompletion() {
        field.bindAutoCompletion("Hello", "World")
        field.bindAutoCompletion(listOf("Hello", "World"))
        field.bindAutoCompletion { listOf("Hello", "World") }
        field.bindAutoCompletion(buildStringConverter {}) { listOf("Hello", "World") }
    }
}