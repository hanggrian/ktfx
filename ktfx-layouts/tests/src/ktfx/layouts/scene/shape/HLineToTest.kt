package ktfx.layouts.scene.shape

import javafx.scene.shape.HLineTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.LayoutTest
import ktfx.layouts.PathElementManager
import ktfx.layouts.hlineTo
import kotlin.test.assertEquals

class HLineToTest : LayoutTest<PathElementManager, HLineTo>() {

    override fun createManager() = KtfxPath()
    override fun create() = hlineTo { }
    override fun PathElementManager.add() = hlineTo()
    override fun PathElementManager.addWithBuilder() = hlineTo { }

    override fun HLineTo.testDefaultValues() {
        assertEquals(0.0, x)
    }
}