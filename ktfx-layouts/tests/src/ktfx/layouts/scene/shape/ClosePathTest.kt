package ktfx.layouts.scene.shape

import javafx.scene.shape.ClosePath
import ktfx.layouts.KtfxPath
import ktfx.layouts.PathElementManager
import ktfx.layouts.closePath
import ktfx.test.LayoutTest

class ClosePathTest : LayoutTest<PathElementManager, ClosePath>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = closePath { }
    override fun PathElementManager.child2() = closePath()
    override fun PathElementManager.child3() = closePath { }
}