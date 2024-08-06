package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.CheckListView

class CheckListViewTest : LayoutsTest<KtfxPane, CheckListView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): CheckListView<String> = checkListView { }

    override fun KtfxPane.child2(): CheckListView<String> = checkListView()

    override fun KtfxPane.child3(): CheckListView<String> = checkListView { }

    override fun CheckListView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
