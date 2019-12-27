package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.HyperlinkLabel
import kotlin.test.assertNull

class HyperlinkLabelTest : LayoutsTest<NodeManager, HyperlinkLabel>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = hyperlinkLabel { }
    override fun NodeManager.child2() = hyperlinkLabel()
    override fun NodeManager.child3() = hyperlinkLabel { }

    override fun HyperlinkLabel.testDefaultValues() {
        assertNull(text)
    }
}