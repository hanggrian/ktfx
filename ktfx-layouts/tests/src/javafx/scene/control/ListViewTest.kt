package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.ListView
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class ListViewTest : LayoutsTest<KtfxPane, ListView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = listView<String> { }
    override fun KtfxPane.child2() = listView<String>()
    override fun KtfxPane.child3() = listView<String> { }

    override fun ListView<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}