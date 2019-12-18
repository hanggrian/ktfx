package ktfx.layouts

import javafx.scene.shape.Path
import ktfx.test.BaseLayoutTest

class PathTest : BaseLayoutTest<NodeManager, Path>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = path { }
    override fun NodeManager.child2() = path()
    override fun NodeManager.child3() = path { }
}