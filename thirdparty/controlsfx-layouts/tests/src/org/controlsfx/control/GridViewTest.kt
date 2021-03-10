package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.GridView

class GridViewTest : LayoutsTest<KtfxPane, GridView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = gridView<String> { }
    override fun KtfxPane.child2() = gridView<String>()
    override fun KtfxPane.child3() = gridView<String> { }

    override fun GridView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}