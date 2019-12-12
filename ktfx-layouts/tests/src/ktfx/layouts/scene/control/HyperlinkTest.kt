package ktfx.layouts.scene.control

import javafx.scene.control.Hyperlink
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.hyperlink
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class HyperlinkTest : BaseLayoutTest<NodeManager, Hyperlink>() {

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