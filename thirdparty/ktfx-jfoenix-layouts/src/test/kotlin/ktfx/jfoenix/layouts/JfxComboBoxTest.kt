package ktfx.jfoenix.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXComboBox
import ktfx.layouts.KtfxPane

class JfxComboBoxTest : LayoutsTest<KtfxPane, JFXComboBox<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXComboBox<String> = jfxComboBox { }

    override fun KtfxPane.child2(): JFXComboBox<String> = jfxComboBox()

    override fun KtfxPane.child3(): JFXComboBox<String> = jfxComboBox { }

    override fun JFXComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
