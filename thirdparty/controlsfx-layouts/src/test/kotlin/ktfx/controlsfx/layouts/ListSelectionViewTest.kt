package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.ListSelectionView

class ListSelectionViewTest : LayoutsTest<KtfxPane, ListSelectionView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): ListSelectionView<String> = listSelectionView { }
    override fun KtfxPane.child2(): ListSelectionView<String> = listSelectionView()
    override fun KtfxPane.child3(): ListSelectionView<String> = listSelectionView { }
}
