package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.PrefixSelectionComboBox

class PrefixSelectionComboBoxTest : LayoutsTest<KtfxPane, PrefixSelectionComboBox<String>>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): PrefixSelectionComboBox<String> = prefixSelectionComboBox { }
    override fun KtfxPane.child2(): PrefixSelectionComboBox<String> = prefixSelectionComboBox()
    override fun KtfxPane.child3(): PrefixSelectionComboBox<String> = prefixSelectionComboBox { }
}
