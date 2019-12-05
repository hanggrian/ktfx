package ktfx.layouts.scene.layout

import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.region

class RegionTest : LayoutTest<NodeManager, Region>() {

    override fun createManager() = KtfxPane()
    override fun create() = region { }
    override fun NodeManager.add() = region()
    override fun NodeManager.addWithBuilder() = region { }
}