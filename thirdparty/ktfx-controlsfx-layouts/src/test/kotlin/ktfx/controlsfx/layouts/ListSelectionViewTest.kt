package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.ListSelectionView

class ListSelectionViewTest : LayoutsStyledTest<KtfxPane, ListSelectionView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = listSelectionView<String> {}

    override fun KtfxPane.child2() = listSelectionView<String>()

    override fun child3() = styledListSelectionView<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledListSelectionView<String>(styleClass = arrayOf("style"))
}
