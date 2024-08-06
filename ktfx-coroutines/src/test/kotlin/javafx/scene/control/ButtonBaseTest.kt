package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.ActionEvent
import javafx.scene.control.Button
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ButtonBaseTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun onAction() {
        val button = Button()
        button.onAction(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        button.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}
