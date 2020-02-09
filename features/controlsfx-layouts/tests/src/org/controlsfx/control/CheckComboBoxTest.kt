package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest
import org.controlsfx.control.CheckComboBox

class CheckComboBoxTest : LayoutsTest<KtfxPane, CheckComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = checkComboBox<String> { }
    override fun KtfxPane.child2() = checkComboBox<String>()
    override fun KtfxPane.child3() = checkComboBox<String> { }

    override fun CheckComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}