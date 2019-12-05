package ktfx.layouts.scene.control

import javafx.scene.control.TabPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.tabPane

class TabPaneTest : LayoutTest<NodeManager, TabPane>() {

    override fun createManager() = KtfxPane()
    override fun create() = tabPane { }
    override fun NodeManager.add() = tabPane()
    override fun NodeManager.addWithBuilder() = tabPane { }
}