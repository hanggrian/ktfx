package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.TableView

class TableViewTest : LayoutsTest<KtfxPane, TableView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): TableView<String> = tableView { }

    override fun KtfxPane.child2(): TableView<String> = tableView()

    override fun KtfxPane.child3(): TableView<String> = tableView { }

    override fun TableView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
