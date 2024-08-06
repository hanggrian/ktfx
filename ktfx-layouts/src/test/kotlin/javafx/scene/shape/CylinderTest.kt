package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Cylinder
import kotlin.test.assertEquals

class CylinderTest : LayoutsTest<KtfxPane, Cylinder>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Cylinder = cylinder { }

    override fun KtfxPane.child2(): Cylinder = cylinder()

    override fun KtfxPane.child3(): Cylinder = cylinder { }

    override fun Cylinder.testDefaultValues() {
        assertEquals(1.0, radius)
        assertEquals(2.0, height)
        assertEquals(64, divisions)
    }
}
