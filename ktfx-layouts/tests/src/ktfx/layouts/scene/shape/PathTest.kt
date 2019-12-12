package ktfx.layouts.scene.shape

import javafx.scene.shape.Path
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.path
import ktfx.test.BaseLayoutTest

class PathTest : BaseLayoutTest<NodeManager, Path>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = path { }
    override fun NodeManager.child2() = path()
    override fun NodeManager.child3() = path { }
}