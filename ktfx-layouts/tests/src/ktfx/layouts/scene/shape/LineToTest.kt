package ktfx.layouts.scene.shape

import javafx.scene.shape.LineTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.LayoutTest
import ktfx.layouts.PathElementManager
import ktfx.layouts.lineTo
import kotlin.test.assertEquals

class LineToTest : LayoutTest<PathElementManager, LineTo>() {

    override fun createManager() = KtfxPath()
    override fun create() = lineTo { }
    override fun PathElementManager.add() = lineTo()
    override fun PathElementManager.addWithBuilder() = lineTo { }

    override fun LineTo.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}