package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Sphere
import kotlin.test.assertEquals

class SphereTest : LayoutsStyledTest<KtfxPane, Sphere>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = sphere {}

    override fun KtfxPane.child2() = sphere()

    override fun child3() = styledSphere()

    override fun KtfxPane.child4() = styledSphere()

    override fun Sphere.testDefaultValues() {
        assertEquals(1.0, radius)
        assertEquals(64, divisions)
    }
}
