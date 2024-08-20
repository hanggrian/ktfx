package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ContextMenuTest : ApplicationTest() {
    override fun start(stage: Stage) {
        stage.testScene<ContextMenu>()
    }

    @Test
    fun onAction() {
        interact {
            val menu = ContextMenu()
            menu.onAction {
                assertEquals(this@ContextMenuTest, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            menu.onAction.handle(ActionEvent(this, FakeEventTarget))
        }
    }
}
