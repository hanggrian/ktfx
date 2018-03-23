package ktfx.styles.scene.layout

import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.layout.HBox
import ktfx.styles.NodeTest
import ktfx.styles.hboxStyle
import kotlin.test.assertEquals

class HBoxStyleTest : NodeTest<HBox>() {

    override fun newInstance() = HBox()

    override val style: String
        get() = hboxStyle(true) {
            spacing = 10
            alignment = TOP_RIGHT
            fillHeight = true
        }

    override fun HBox.assertion() {
        assertEquals(spacing, 10.0)
        assertEquals(alignment, TOP_RIGHT)
        assertEquals(isFillHeight, true)
    }
}