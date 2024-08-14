package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Polyline

class PolylineTest : LayoutsStyledTest<KtfxPane, Polyline>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = polyline {}

    override fun KtfxPane.child2() = polyline()

    override fun child3() = styledPolyline(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledPolyline(styleClass = arrayOf("style"))

    override fun Polyline.testDefaultValues() {
        assertThat(points).isEmpty()
    }
}
