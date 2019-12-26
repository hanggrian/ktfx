package ktfx.layouts

import javafx.scene.layout.BorderPane
import ktfx.test.LayoutTest

class BorderPaneTest : LayoutTest<NodeManager, BorderPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = borderPane { }
    override fun NodeManager.child2() = borderPane()
    override fun NodeManager.child3() = borderPane { }
}