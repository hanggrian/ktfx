package ktfx.layouts.scene.shape

import javafx.scene.shape.Path
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.path

class PathTest : LayoutTest<NodeManager, Path>() {

    override fun createManager() = KtfxPane()
    override fun create() = path { }
    override fun NodeManager.add() = path()
    override fun NodeManager.addWithBuilder() = path { }
}