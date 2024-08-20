package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.CheckComboBox

class CheckComboBoxTest : LayoutsStyledTest<KtfxPane, CheckComboBox<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = checkComboBox<String> {}

    override fun KtfxPane.child2() = checkComboBox<String>()

    override fun child3() = styledCheckComboBox<String>()

    override fun KtfxPane.child4() = styledCheckComboBox<String>()

    override fun CheckComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
