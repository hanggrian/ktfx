package ktfx.styles.scene.layout

import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.layout.VBox
import ktfx.styles.NodeTest
import ktfx.styles.vboxStyle
import kotlin.test.assertEquals

class VBoxStyleTest : NodeTest<VBox>() {

    override fun newInstance() = VBox()

    override val style: String
        get() = vboxStyle {
            spacing = 10
            alignment = TOP_RIGHT
            fillWidth = true
        }

    override fun VBox.assertion() {
        assertEquals(spacing, 10.0)
        assertEquals(alignment, TOP_RIGHT)
        assertEquals(isFillWidth, true)
    }
}