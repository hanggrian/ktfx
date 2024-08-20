package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.CheckListView

class CheckListViewTest : LayoutsStyledTest<KtfxPane, CheckListView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = checkListView<String> {}

    override fun KtfxPane.child2() = checkListView<String>()

    override fun child3() = styledCheckListView<String>()

    override fun KtfxPane.child4() = styledCheckListView<String>()

    override fun CheckListView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
