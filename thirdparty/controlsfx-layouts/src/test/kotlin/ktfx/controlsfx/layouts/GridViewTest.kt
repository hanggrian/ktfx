package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.GridView

class GridViewTest : LayoutsTest<KtfxPane, GridView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): GridView<String> = gridView { }
    override fun KtfxPane.child2(): GridView<String> = gridView()
    override fun KtfxPane.child3(): GridView<String> = gridView { }

    override fun GridView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
