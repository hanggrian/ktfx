package ktfx.styles.scene.control

import javafx.geometry.Orientation.VERTICAL
import javafx.scene.control.Label
import javafx.scene.control.SplitPane
import ktfx.styles.NodeTest
import ktfx.styles.splitPaneStyle
import kotlin.test.assertEquals

class SplitPaneStyleTest : NodeTest<SplitPane>() {

    override fun newInstance() = SplitPane(Label("Hello"), Label("world"))

    override val style: String
        get() = splitPaneStyle(true) {
            orientation = VERTICAL
        }

    override fun SplitPane.assertion() {
        assertEquals(orientation, VERTICAL)
    }
}