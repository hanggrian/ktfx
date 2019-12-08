package ktfx.layouts.scene.shape

import javafx.scene.shape.LineTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.PathElementManager
import ktfx.layouts.lineTo
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class LineToTest : LayoutTest<PathElementManager, LineTo>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = lineTo { }
    override fun PathElementManager.child2() = lineTo()
    override fun PathElementManager.child3() = lineTo { }

    override fun LineTo.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}