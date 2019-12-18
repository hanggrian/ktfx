package ktfx.layouts

import javafx.scene.shape.ClosePath
import ktfx.test.BaseLayoutTest

class ClosePathTest : BaseLayoutTest<PathElementManager, ClosePath>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = closePath { }
    override fun PathElementManager.child2() = closePath()
    override fun PathElementManager.child3() = closePath { }
}