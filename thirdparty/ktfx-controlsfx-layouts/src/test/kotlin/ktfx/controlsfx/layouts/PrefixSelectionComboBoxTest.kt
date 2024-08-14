package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.PrefixSelectionComboBox

class PrefixSelectionComboBoxTest :
    LayoutsStyledTest<KtfxPane, PrefixSelectionComboBox<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = prefixSelectionComboBox<String> {}

    override fun KtfxPane.child2() = prefixSelectionComboBox<String>()

    override fun child3() = styledPrefixSelectionComboBox<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() =
        styledPrefixSelectionComboBox<String>(styleClass = arrayOf("style"))
}
