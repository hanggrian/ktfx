package ktfx.layouts.scene.layout

import javafx.geometry.Orientation
import javafx.scene.layout.TilePane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.tilePane
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class TilePaneTest : BaseLayoutTest<NodeManager, TilePane>() {

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