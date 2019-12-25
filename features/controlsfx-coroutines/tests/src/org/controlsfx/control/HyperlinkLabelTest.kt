package ktfx.controlsfx.coroutines

import javafx.event.ActionEvent
import kotlinx.coroutines.Dispatchers
import ktfx.controlsfx.test.BaseHyperlinkLabelTest
import org.controlsfx.control.HyperlinkLabel

class HyperlinkLabelTest : BaseHyperlinkLabelTest() {

    override fun HyperlinkLabel.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }
}