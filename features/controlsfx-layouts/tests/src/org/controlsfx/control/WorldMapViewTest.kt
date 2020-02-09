package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest
import org.controlsfx.control.WorldMapView

class WorldMapViewTest : LayoutsTest<KtfxPane, WorldMapView>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = worldMapView { }
    override fun KtfxPane.child2() = worldMapView()
    override fun KtfxPane.child3() = worldMapView { }
}