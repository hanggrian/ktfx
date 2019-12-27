package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.ComboBox
import ktfx.test.LayoutsTest

class ComboBoxTest : LayoutsTest<NodeManager, ComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = comboBox<String> { }
    override fun NodeManager.child2() = comboBox<String>()
    override fun NodeManager.child3() = comboBox<String> { }

    override fun ComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}