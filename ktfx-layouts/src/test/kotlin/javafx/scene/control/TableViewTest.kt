package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.TableView

class TableViewTest : LayoutsStyledTest<KtfxPane, TableView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = tableView<String> {}

    override fun KtfxPane.child2() = tableView<String>()

    override fun child3() = styledTableView<String>()

    override fun KtfxPane.child4() = styledTableView<String>()

    override fun TableView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
