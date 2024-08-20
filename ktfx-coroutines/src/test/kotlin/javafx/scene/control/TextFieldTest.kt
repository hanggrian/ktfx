package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.ActionEvent
import javafx.scene.control.TextField
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFieldTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<TextField>()
    }

    @Test
    fun onAction() {
        interact {
            val field = TextField()
            field.onAction {
                assertEquals(this@TextFieldTest, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            field.onAction.handle(ActionEvent(this, FakeEventTarget))
        }
    }
}
