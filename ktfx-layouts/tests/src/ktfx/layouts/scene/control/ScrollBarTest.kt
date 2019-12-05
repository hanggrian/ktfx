package ktfx.layouts.scene.control

import javafx.scene.control.ScrollBar
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.scrollBar

class ScrollBarTest : LayoutTest<NodeManager, ScrollBar>() {

    override fun createManager() = KtfxPane()
    override fun create() = scrollBar { }
    override fun NodeManager.add() = scrollBar()
    override fun NodeManager.addWithBuilder() = scrollBar { }
}