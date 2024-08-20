package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.GridView

class GridViewTest : LayoutsStyledTest<KtfxPane, GridView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = gridView<String> {}

    override fun KtfxPane.child2() = gridView<String>()

    override fun child3() = styledGridView<String>()

    override fun KtfxPane.child4() = styledGridView<String>()

    override fun GridView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
