package ktfx.jfoenix.coroutines

import com.hanggrian.ktfx.test.testScene
import com.jfoenix.controls.JFXDecorator
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertTrue

// sometimes fail on CLI
@Ignore
class JfxDecoratorTest : ApplicationTest() {
    private lateinit var decorator: JFXDecorator

    override fun start(stage: Stage) {
        decorator = JFXDecorator(stage, Label("Hello world"))
        stage.testScene<JFXDecorator>()
    }

    @Test
    fun onCloseButtonAction() {
        var assigned = false
        interact {
            decorator.onCloseButtonAction {
                assigned = true
            }
            ((decorator.children.first() as Pane).children.last() as Button).fire()
        }
        assertTrue(assigned)
    }
}
