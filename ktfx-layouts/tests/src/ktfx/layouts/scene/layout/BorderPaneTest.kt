package ktfx.layouts.scene.layout

import javafx.scene.layout.BorderPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.borderPane

class BorderPaneTest : LayoutTest<NodeManager, BorderPane>() {

    override fun createManager() = KtfxPane()
    override fun create() = borderPane { }
    override fun NodeManager.add() = borderPane()
    override fun NodeManager.addWithBuilder() = borderPane { }
}