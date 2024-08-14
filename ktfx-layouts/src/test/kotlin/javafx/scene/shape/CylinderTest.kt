package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Cylinder
import kotlin.test.assertEquals

class CylinderTest : LayoutsStyledTest<KtfxPane, Cylinder>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = cylinder {}

    override fun KtfxPane.child2() = cylinder()

    override fun child3() = styledCylinder(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledCylinder(styleClass = arrayOf("style"))

    override fun Cylinder.testDefaultValues() {
        assertEquals(1.0, radius)
        assertEquals(2.0, height)
        assertEquals(64, divisions)
    }
}
