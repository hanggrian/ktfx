package ktfx.layouts.scene.layout

import javafx.scene.layout.Pane
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.pane

class PaneTest : LayoutTest<NodeManager, Pane>() {

    override fun createManager() = KtfxPane()
    override fun create() = pane { }
    override fun NodeManager.add() = pane()
    override fun NodeManager.addWithBuilder() = pane { }
}