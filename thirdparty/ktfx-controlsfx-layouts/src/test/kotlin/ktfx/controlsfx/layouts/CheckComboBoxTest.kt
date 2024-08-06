package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.CheckComboBox

class CheckComboBoxTest : LayoutsTest<KtfxPane, CheckComboBox<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): CheckComboBox<String> = checkComboBox<String> { }

    override fun KtfxPane.child2(): CheckComboBox<String> = checkComboBox<String>()

    override fun KtfxPane.child3(): CheckComboBox<String> = checkComboBox<String> { }

    override fun CheckComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
