package ktfx.layouts.scene.layout

import javafx.scene.layout.Pane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.pane
import ktfx.test.LayoutTest

class PaneTest : LayoutTest<NodeManager, Pane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = pane { }
    override fun NodeManager.child2() = pane()
    override fun NodeManager.child3() = pane { }
}