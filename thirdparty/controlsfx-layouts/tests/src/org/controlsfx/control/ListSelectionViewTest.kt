package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.ListSelectionView

class ListSelectionViewTest : LayoutsTest<KtfxPane, ListSelectionView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = listSelectionView<String> { }
    override fun KtfxPane.child2() = listSelectionView<String>()
    override fun KtfxPane.child3() = listSelectionView<String> { }
}