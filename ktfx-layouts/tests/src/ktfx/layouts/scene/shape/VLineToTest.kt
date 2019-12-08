package ktfx.layouts.scene.shape

import javafx.scene.shape.VLineTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.PathElementManager
import ktfx.layouts.vlineTo
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class VLineToTest : LayoutTest<PathElementManager, VLineTo>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = vlineTo { }
    override fun PathElementManager.child2() = vlineTo()
    override fun PathElementManager.child3() = vlineTo { }

    override fun VLineTo.testDefaultValues() {
        assertEquals(0.0, y)
    }
}