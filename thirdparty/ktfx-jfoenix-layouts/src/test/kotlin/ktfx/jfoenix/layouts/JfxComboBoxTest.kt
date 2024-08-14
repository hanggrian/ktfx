package ktfx.jfoenix.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXComboBox
import ktfx.layouts.KtfxPane

class JfxComboBoxTest : LayoutsStyledTest<KtfxPane, JFXComboBox<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxComboBox<String> {}

    override fun KtfxPane.child2() = jfxComboBox<String>()

    override fun child3() = styledJfxComboBox<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxComboBox<String>(styleClass = arrayOf("style"))

    override fun JFXComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
