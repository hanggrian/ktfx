package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.PrefixSelectionChoiceBox

class PrefixSelectionChoiceBoxTest : LayoutsTest<KtfxPane, PrefixSelectionChoiceBox<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = prefixSelectionChoiceBox<String> { }
    override fun KtfxPane.child2() = prefixSelectionChoiceBox<String>()
    override fun KtfxPane.child3() = prefixSelectionChoiceBox<String> { }
}
