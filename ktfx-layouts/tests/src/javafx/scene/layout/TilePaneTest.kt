package ktfx.layouts

import javafx.geometry.Orientation
import javafx.scene.layout.TilePane
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class TilePaneTest : LayoutTest<NodeManager, TilePane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = tilePane { }
    override fun NodeManager.child2() = tilePane()
    override fun NodeManager.child3() = tilePane { }

    override fun TilePane.testDefaultValues() {
        assertEquals(Orientation.HORIZONTAL, orientation)
        assertEquals(0.0, hgap)
        assertEquals(0.0, vgap)
    }
}