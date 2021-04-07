package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.ComboBox
import com.hendraanggrian.ktfx.test.LayoutsTest

class ComboBoxTest : LayoutsTest<KtfxPane, ComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = comboBox<String> { }
    override fun KtfxPane.child2() = comboBox<String>()
    override fun KtfxPane.child3() = comboBox<String> { }

    override fun ComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}