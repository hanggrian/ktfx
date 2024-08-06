package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.geometry.Orientation
import javafx.scene.layout.TilePane
import kotlin.test.assertEquals

class TilePaneTest : LayoutsTest<KtfxPane, TilePane>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): TilePane = tilePane { }

    override fun KtfxPane.child2(): TilePane = tilePane()

    override fun KtfxPane.child3(): TilePane = tilePane { }

    override fun TilePane.testDefaultValues() {
        assertEquals(Orientation.HORIZONTAL, orientation)
        assertEquals(0.0, hgap)
        assertEquals(0.0, vgap)
    }
}
