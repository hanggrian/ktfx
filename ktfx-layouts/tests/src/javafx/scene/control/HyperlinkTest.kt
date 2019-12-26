package ktfx.layouts

import javafx.scene.control.Hyperlink
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class HyperlinkTest : LayoutTest<NodeManager, Hyperlink>() {

    override fun manager(): NodeManager = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = hyperlink { }
    override fun NodeManager.child2() = hyperlink()
    override fun NodeManager.child3() = hyperlink { }

    override fun Hyperlink.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}