package ktfx.layouts.scene.control

import javafx.scene.control.ScrollBar
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.scrollBar
import ktfx.test.LayoutTest

class ScrollBarTest : LayoutTest<NodeManager, ScrollBar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = scrollBar { }
    override fun NodeManager.child2() = scrollBar()
    override fun NodeManager.child3() = scrollBar { }
}