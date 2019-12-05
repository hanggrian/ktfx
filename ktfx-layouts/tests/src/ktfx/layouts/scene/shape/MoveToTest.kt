package ktfx.layouts.scene.shape

import javafx.scene.shape.MoveTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.LayoutTest
import ktfx.layouts.PathElementManager
import ktfx.layouts.moveTo
import kotlin.test.assertEquals

class MoveToTest : LayoutTest<PathElementManager, MoveTo>() {

    override fun createManager() = KtfxPath()
    override fun create() = moveTo { }
    override fun PathElementManager.add() = moveTo()
    override fun PathElementManager.addWithBuilder() = moveTo { }

    override fun MoveTo.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}