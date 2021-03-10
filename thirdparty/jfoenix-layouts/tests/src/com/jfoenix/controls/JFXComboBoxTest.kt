package ktfx.jfoenix.layouts

import com.google.common.truth.Truth.assertThat
import com.jfoenix.controls.JFXComboBox
import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class JFXComboBoxTest : LayoutsTest<KtfxPane, JFXComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxComboBox<String> { }
    override fun KtfxPane.child2() = jfxComboBox<String>()
    override fun KtfxPane.child3() = jfxComboBox<String> { }

    override fun JFXComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}