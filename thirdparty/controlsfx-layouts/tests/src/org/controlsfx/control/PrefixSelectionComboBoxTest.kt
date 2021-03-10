package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.PrefixSelectionComboBox

class PrefixSelectionComboBoxTest : LayoutsTest<KtfxPane, PrefixSelectionComboBox<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = prefixSelectionComboBox<String> { }
    override fun KtfxPane.child2() = prefixSelectionComboBox<String>()
    override fun KtfxPane.child3() = prefixSelectionComboBox<String> { }
}