package ktfx.jfoenix.layouts

import com.google.common.truth.Truth.assertThat
import com.jfoenix.controls.JFXComboBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest

class JFXComboBoxTest : LayoutsTest<NodeManager, JFXComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxComboBox<String> { }
    override fun NodeManager.child2() = jfxComboBox<String>()
    override fun NodeManager.child3() = jfxComboBox<String> { }

    override fun JFXComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}