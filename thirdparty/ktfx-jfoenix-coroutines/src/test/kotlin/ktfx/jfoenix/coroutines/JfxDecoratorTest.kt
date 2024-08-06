package ktfx.jfoenix.coroutines

import com.jfoenix.controls.JFXDecorator
import javafx.scene.control.Label
import javafx.stage.Stage
import kotlinx.coroutines.Dispatchers
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test

class JfxDecoratorTest : ApplicationTest() {
    private lateinit var decorator: JFXDecorator

    override fun start(stage: Stage) {
        decorator = JFXDecorator(stage, Label("Hello world"))
    }

    @Test
    fun onCloseButtonAction() {
        decorator.onCloseButtonAction(Dispatchers.Unconfined) {}
    }
}
