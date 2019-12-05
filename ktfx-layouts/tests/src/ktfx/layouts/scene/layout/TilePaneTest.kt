package ktfx.layouts.scene.layout

import javafx.geometry.Orientation
import javafx.scene.layout.TilePane
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.tilePane
import kotlin.test.assertEquals

class TilePaneTest : LayoutTest<NodeManager, TilePane>() {

    override fun createManager() = KtfxPane()
    override fun create() = tilePane { }
    override fun NodeManager.add() = tilePane()
    override fun NodeManager.addWithBuilder() = tilePane { }

    override fun TilePane.testDefaultValues() {
        assertEquals(Orientation.HORIZONTAL, orientation)
        assertEquals(0.0, hgap)
        assertEquals(0.0, vgap)
    }
}