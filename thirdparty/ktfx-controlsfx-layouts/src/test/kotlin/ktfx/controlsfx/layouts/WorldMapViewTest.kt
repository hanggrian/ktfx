package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.WorldMapView

class WorldMapViewTest : LayoutsStyledTest<KtfxPane, WorldMapView>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = worldMapView {}

    override fun KtfxPane.child2() = worldMapView()

    override fun child3() = styledWorldMapView()

    override fun KtfxPane.child4() = styledWorldMapView()
}
