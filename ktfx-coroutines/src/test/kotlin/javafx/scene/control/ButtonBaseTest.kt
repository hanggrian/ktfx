package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.ButtonBase
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ButtonBaseTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<ButtonBase>()
    }

    @Test
    fun onAction() {
        interact {
            val button = Button()
            button.onAction {
                assertEquals(this@ButtonBaseTest, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            button.onAction.handle(ActionEvent(this, FakeEventTarget))
        }
    }
}
