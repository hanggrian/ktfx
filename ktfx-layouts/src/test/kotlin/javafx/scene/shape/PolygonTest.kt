package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Polygon

class PolygonTest : LayoutsTest<KtfxPane, Polygon>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): Polygon = polygon { }
    override fun KtfxPane.child2(): Polygon = polygon()
    override fun KtfxPane.child3(): Polygon = polygon { }

    override fun Polygon.testDefaultValues() {
        assertThat(points).isEmpty()
    }
}
