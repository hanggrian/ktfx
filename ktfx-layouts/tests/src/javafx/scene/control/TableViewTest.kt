package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.TableView
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class TableViewTest : LayoutsTest<KtfxPane, TableView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = tableView<String> { }
    override fun KtfxPane.child2() = tableView<String>()
    override fun KtfxPane.child3() = tableView<String> { }

    override fun TableView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}