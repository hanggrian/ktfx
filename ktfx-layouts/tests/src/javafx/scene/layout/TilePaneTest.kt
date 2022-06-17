package ktfx.layouts

import javafx.geometry.Orientation
import javafx.scene.layout.TilePane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class TilePaneTest : LayoutsTest<KtfxPane, TilePane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = tilePane { }
    override fun KtfxPane.child2() = tilePane()
    override fun KtfxPane.child3() = tilePane { }

    override fun TilePane.testDefaultValues() {
        assertEquals(Orientation.HORIZONTAL, orientation)
        assertEquals(0.0, hgap)
        assertEquals(0.0, vgap)
    }
}
