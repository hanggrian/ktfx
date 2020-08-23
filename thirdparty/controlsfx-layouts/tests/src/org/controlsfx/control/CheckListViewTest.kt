package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.CheckListView

class CheckListViewTest : LayoutsTest<KtfxPane, CheckListView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = checkListView<String> { }
    override fun KtfxPane.child2() = checkListView<String>()
    override fun KtfxPane.child3() = checkListView<String> { }

    override fun CheckListView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}