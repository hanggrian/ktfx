package ktfx.controlsfx.listeners

import javafx.event.ActionEvent
import ktfx.controlsfx.test.BaseHyperlinkLabelTest
import org.controlsfx.control.HyperlinkLabel

class HyperlinkLabelTest : BaseHyperlinkLabelTest() {
    override fun HyperlinkLabel.callOnAction(
        action: (ActionEvent) -> Unit
    ): Unit = onAction(action)
}
