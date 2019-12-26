package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import org.controlsfx.control.CheckComboBox

class CheckComboBoxTest : LayoutTest<NodeManager, CheckComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = checkComboBox<String> { }
    override fun NodeManager.child2() = checkComboBox<String>()
    override fun NodeManager.child3() = checkComboBox<String> { }

    override fun CheckComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}