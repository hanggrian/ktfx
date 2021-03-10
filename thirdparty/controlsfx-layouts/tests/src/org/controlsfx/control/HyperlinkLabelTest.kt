package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.HyperlinkLabel
import kotlin.test.assertNull

class HyperlinkLabelTest : LayoutsTest<KtfxPane, HyperlinkLabel>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = hyperlinkLabel { }
    override fun KtfxPane.child2() = hyperlinkLabel()
    override fun KtfxPane.child3() = hyperlinkLabel { }

    override fun HyperlinkLabel.testDefaultValues() {
        assertNull(text)
    }
}