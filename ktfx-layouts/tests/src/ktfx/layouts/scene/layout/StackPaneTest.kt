package ktfx.layouts.scene.layout

import javafx.scene.layout.StackPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.stackPane

class StackPaneTest : LayoutTest<NodeManager, StackPane>() {

    override fun createManager() = KtfxPane()
    override fun create() = stackPane { }
    override fun NodeManager.add() = stackPane()
    override fun NodeManager.addWithBuilder() = stackPane { }
}