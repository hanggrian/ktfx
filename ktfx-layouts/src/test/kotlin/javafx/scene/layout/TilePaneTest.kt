package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.geometry.Orientation
import javafx.scene.layout.TilePane
import kotlin.test.assertEquals

class TilePaneTest : LayoutsStyledTest<KtfxPane, TilePane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = tilePane {}

    override fun KtfxPane.child2() = tilePane()

    override fun child3() = styledTilePane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledTilePane(styleClass = arrayOf("style"))

    override fun TilePane.testDefaultValues() {
        assertEquals(Orientation.HORIZONTAL, orientation)
        assertEquals(0.0, hgap)
        assertEquals(0.0, vgap)
    }
}
