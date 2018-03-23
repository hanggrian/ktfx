package ktfx.styles.scene.control

import javafx.scene.control.Label
import javafx.scene.control.TitledPane
import ktfx.styles.NodeTest
import ktfx.styles.titledPaneStyle
import kotlin.test.assertEquals

class TitledPaneStyleTest : NodeTest<TitledPane>() {

    override fun newInstance() = TitledPane("Hello world", Label("Hello world"))

    override val style: String
        get() = titledPaneStyle(true) {
            // animated = false
            // collapsible = false
        }

    override fun TitledPane.assertion() {
        // assertEquals(isAnimated, false)
        // assertEquals(isCollapsible, false)
    }
}