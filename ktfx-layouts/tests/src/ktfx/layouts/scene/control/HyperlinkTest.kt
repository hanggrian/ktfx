package ktfx.layouts.scene.control

import javafx.scene.control.Hyperlink
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.hyperlink
import kotlin.test.assertNull

class HyperlinkTest : LayoutTest<NodeManager, Hyperlink>(KtfxPane()) {

    override fun create() = hyperlink { }
    override fun NodeManager.add() = hyperlink()
    override fun NodeManager.addWithBuilder() = hyperlink { }

    override fun Hyperlink.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}