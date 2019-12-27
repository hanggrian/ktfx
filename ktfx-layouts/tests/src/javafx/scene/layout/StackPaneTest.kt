package ktfx.layouts

import javafx.scene.layout.StackPane
import ktfx.test.LayoutsTest

class StackPaneTest : LayoutsTest<NodeManager, StackPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = stackPane { }
    override fun NodeManager.child2() = stackPane()
    override fun NodeManager.child3() = stackPane { }
}