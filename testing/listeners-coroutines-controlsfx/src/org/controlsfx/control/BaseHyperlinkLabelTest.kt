package ktfx.controlsfx.test

import javafx.event.ActionEvent
import io.github.hendraanggrian.ktfx.test.FakeEventTarget
import io.github.hendraanggrian.ktfx.test.initToolkit
import org.controlsfx.control.HyperlinkLabel
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseHyperlinkLabelTest {
    private lateinit var label: HyperlinkLabel

    abstract fun HyperlinkLabel.callOnAction(action: (ActionEvent) -> Unit)

    @BeforeTest fun create() {
        initToolkit()
        label = HyperlinkLabel()
    }

    @Test fun onAction() {
        label.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        label.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}