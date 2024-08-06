package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ContextMenuTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun onAction() {
        val menu = ContextMenu()
        menu.onAction(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        menu.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}
