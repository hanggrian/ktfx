package ktfx.jfoenix.test

import com.jfoenix.controls.JFXDecorator
import javafx.scene.control.Label
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test

abstract class BaseJFXDecoratorTest : ApplicationTest() {
    private lateinit var decorator: JFXDecorator

    abstract fun JFXDecorator.callOnCloseButtonAction(action: () -> Unit)

    override fun start(stage: Stage) {
        decorator = JFXDecorator(stage, Label("Hello world"))
    }

    @Test
    fun onCloseButtonAction() {
        decorator.callOnCloseButtonAction { }
    }
}
