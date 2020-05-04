package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.shape.Polyline
import com.hendraanggrian.ktfx.test.LayoutsTest

class PolylineTest : LayoutsTest<KtfxPane, Polyline>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = polyline { }
    override fun KtfxPane.child2() = polyline()
    override fun KtfxPane.child3() = polyline { }

    override fun Polyline.testDefaultValues() {
        assertThat(points).isEmpty()
    }
}