package ktfx.layouts

import javafx.scene.layout.Region
import ktfx.test.LayoutTest

class RegionTest : LayoutTest<NodeManager, Region>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = region { }
    override fun NodeManager.child2() = region()
    override fun NodeManager.child3() = region { }
}