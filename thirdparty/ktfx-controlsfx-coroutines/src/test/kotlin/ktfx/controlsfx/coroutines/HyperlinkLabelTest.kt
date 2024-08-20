package ktfx.controlsfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.ActionEvent
import javafx.stage.Stage
import org.controlsfx.control.HyperlinkLabel
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class HyperlinkLabelTest : ApplicationTest() {
    private lateinit var label: HyperlinkLabel

    override fun start(stage: Stage) {
        stage.testScene<HyperlinkLabel>()
        label = HyperlinkLabel()
    }

    @Test
    fun onAction() {
        interact {
            label.onAction {
                assertEquals(this@HyperlinkLabelTest, it.source)
                assertEquals(FakeEventTarget, it.target)
            }
            label.onAction.handle(ActionEvent(this, FakeEventTarget))
        }
    }
}
