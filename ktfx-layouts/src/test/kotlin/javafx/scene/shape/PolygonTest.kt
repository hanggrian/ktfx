package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Polygon

class PolygonTest : LayoutsStyledTest<KtfxPane, Polygon>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = polygon {}

    override fun KtfxPane.child2() = polygon()

    override fun child3() = styledPolygon(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledPolygon(styleClass = arrayOf("style"))

    override fun Polygon.testDefaultValues() {
        assertThat(points).isEmpty()
    }
}
