package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Polyline

class PolylineTest : LayoutsTest<KtfxPane, Polyline>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Polyline = polyline { }

    override fun KtfxPane.child2(): Polyline = polyline()

    override fun KtfxPane.child3(): Polyline = polyline { }

    override fun Polyline.testDefaultValues() {
        assertThat(points).isEmpty()
    }
}
