package ktfx.layouts.scene.control

import javafx.scene.control.ScrollPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.scrollPane
import kotlin.test.assertNull

class ScrollPaneTest : LayoutTest<NodeManager, ScrollPane>() {

    override fun createManager() = KtfxPane()
    override fun create() = scrollPane { }
    override fun NodeManager.add() = scrollPane()
    override fun NodeManager.addWithBuilder() = scrollPane { }

    override fun ScrollPane.testDefaultValues() {
        assertNull(content)
    }
}