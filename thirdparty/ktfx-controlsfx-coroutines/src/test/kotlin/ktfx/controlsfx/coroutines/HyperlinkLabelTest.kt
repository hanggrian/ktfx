package ktfx.controlsfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.ActionEvent
import kotlinx.coroutines.Dispatchers
import org.controlsfx.control.HyperlinkLabel
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class HyperlinkLabelTest {
    private lateinit var label: HyperlinkLabel

    @BeforeTest
    fun create() {
        initToolkit()
        label = HyperlinkLabel()
    }

    @Test
    fun onAction() {
        label.onAction(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        label.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}
