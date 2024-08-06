package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.WorldMapView

class WorldMapViewTest : LayoutsTest<KtfxPane, WorldMapView>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): WorldMapView = worldMapView { }

    override fun KtfxPane.child2(): WorldMapView = worldMapView()

    override fun KtfxPane.child3(): WorldMapView = worldMapView { }
}
