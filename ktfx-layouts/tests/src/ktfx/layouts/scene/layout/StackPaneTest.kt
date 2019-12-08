package ktfx.layouts.scene.layout

import javafx.scene.layout.StackPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.stackPane
import ktfx.test.LayoutTest

class StackPaneTest : LayoutTest<NodeManager, StackPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = stackPane { }
    override fun NodeManager.child2() = stackPane()
    override fun NodeManager.child3() = stackPane { }
}