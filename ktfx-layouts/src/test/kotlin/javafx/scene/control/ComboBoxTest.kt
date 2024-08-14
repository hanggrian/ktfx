package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ComboBox

class ComboBoxTest : LayoutsStyledTest<KtfxPane, ComboBox<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = comboBox<String> {}

    override fun KtfxPane.child2() = comboBox<String>()

    override fun child3() = styledComboBox<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledComboBox<String>(styleClass = arrayOf("style"))

    override fun ComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
