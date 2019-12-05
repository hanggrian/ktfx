package ktfx.layouts.scene.control

import javafx.scene.control.SplitPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.splitPane

class SplitPaneTest : LayoutTest<NodeManager, SplitPane>() {

    override fun createManager() = KtfxPane()
    override fun create() = splitPane { }
    override fun NodeManager.add() = splitPane()
    override fun NodeManager.addWithBuilder() = splitPane { }
}