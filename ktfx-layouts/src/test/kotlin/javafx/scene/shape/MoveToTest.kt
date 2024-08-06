package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.MoveTo
import kotlin.test.assertEquals

class MoveToTest : LayoutsTest<KtfxPath, MoveTo>() {
    override fun manager(): KtfxPath = KtfxPath()

    override fun KtfxPath.childCount(): Int = elements.size

    override fun child1(): MoveTo = moveTo { }

    override fun KtfxPath.child2(): MoveTo = moveTo()

    override fun KtfxPath.child3(): MoveTo = moveTo { }

    override fun MoveTo.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}
