package ktfx.styles.scene.control

import javafx.geometry.Orientation.VERTICAL
import javafx.scene.control.ScrollBar
import ktfx.styles.NodeTest
import ktfx.styles.scrollBarStyle
import kotlin.test.assertEquals

class ScrollBarStyleTest : NodeTest<ScrollBar>() {

    override fun newInstance() = ScrollBar()

    override val style: String
        get() = scrollBarStyle {
            orientation = VERTICAL
            blockIncrement = 5
            unitIncrement = 10
        }

    override fun ScrollBar.assertion() {
        assertEquals(orientation, VERTICAL)
        assertEquals(blockIncrement, 5.0)
        assertEquals(unitIncrement, 10.0)
    }
}