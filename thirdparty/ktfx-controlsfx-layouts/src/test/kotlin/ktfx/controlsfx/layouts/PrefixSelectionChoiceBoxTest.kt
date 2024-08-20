package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.PrefixSelectionChoiceBox

class PrefixSelectionChoiceBoxTest :
    LayoutsStyledTest<KtfxPane, PrefixSelectionChoiceBox<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = prefixSelectionChoiceBox<String> {}

    override fun KtfxPane.child2() = prefixSelectionChoiceBox<String>()

    override fun child3() = styledPrefixSelectionChoiceBox<String>()

    override fun KtfxPane.child4() = styledPrefixSelectionChoiceBox<String>()
}
