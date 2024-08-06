package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.PrefixSelectionChoiceBox

class PrefixSelectionChoiceBoxTest : LayoutsTest<KtfxPane, PrefixSelectionChoiceBox<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): PrefixSelectionChoiceBox<String> = prefixSelectionChoiceBox { }

    override fun KtfxPane.child2(): PrefixSelectionChoiceBox<String> = prefixSelectionChoiceBox()

    override fun KtfxPane.child3(): PrefixSelectionChoiceBox<String> = prefixSelectionChoiceBox { }
}
