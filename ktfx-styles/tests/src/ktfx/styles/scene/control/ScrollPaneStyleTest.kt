package ktfx.styles.scene.control

import javafx.scene.control.ScrollPane
import javafx.scene.control.ScrollPane.ScrollBarPolicy.ALWAYS
import javafx.scene.control.ScrollPane.ScrollBarPolicy.NEVER
import ktfx.styles.NodeTest
import ktfx.styles.scrollPaneStyle
import kotlin.test.assertEquals

class ScrollPaneStyleTest : NodeTest<ScrollPane>() {

    override fun newInstance() = ScrollPane()

    override val style: String
        get() = scrollPaneStyle {
            fitToWidth = true
            fitToHeight = true
            pannable = true
            hbarPolicy = ALWAYS
            vbarPolicy = NEVER
        }

    override fun ScrollPane.assertion() {
        assertEquals(isFitToWidth, true)
        assertEquals(isFitToHeight, true)
        assertEquals(isPannable, true)
        assertEquals(hbarPolicy, ALWAYS)
        assertEquals(vbarPolicy, NEVER)
    }
}