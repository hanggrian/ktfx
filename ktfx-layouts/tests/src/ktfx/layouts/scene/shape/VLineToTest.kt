package ktfx.layouts.scene.shape

import javafx.scene.shape.VLineTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.LayoutTest
import ktfx.layouts.PathElementManager
import ktfx.layouts.vlineTo
import kotlin.test.assertEquals

class VLineToTest : LayoutTest<PathElementManager, VLineTo>() {

    override fun createManager() = KtfxPath()
    override fun create() = vlineTo { }
    override fun PathElementManager.add() = vlineTo()
    override fun PathElementManager.addWithBuilder() = vlineTo { }

    override fun VLineTo.testDefaultValues() {
        assertEquals(0.0, y)
    }
}