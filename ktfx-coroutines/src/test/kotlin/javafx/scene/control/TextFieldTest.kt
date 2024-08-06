package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.ActionEvent
import javafx.scene.control.TextField
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFieldTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun onAction() {
        val field = TextField()
        field.onAction(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        field.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}
