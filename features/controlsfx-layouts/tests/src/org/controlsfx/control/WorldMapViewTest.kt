package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import org.controlsfx.control.WorldMapView

class WorldMapViewTest : BaseLayoutTest<NodeManager, WorldMapView>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = worldMapView { }
    override fun NodeManager.child2() = worldMapView()
    override fun NodeManager.child3() = worldMapView { }
}