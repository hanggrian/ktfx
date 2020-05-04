package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.shape.Polygon
import com.hendraanggrian.ktfx.test.LayoutsTest

class PolygonTest : LayoutsTest<KtfxPane, Polygon>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = polygon { }
    override fun KtfxPane.child2() = polygon()
    override fun KtfxPane.child3() = polygon { }

    override fun Polygon.testDefaultValues() {
        assertThat(points).isEmpty()
    }
}