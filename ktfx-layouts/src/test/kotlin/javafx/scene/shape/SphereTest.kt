package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Sphere
import kotlin.test.assertEquals

class SphereTest : LayoutsTest<KtfxPane, Sphere>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Sphere = sphere { }

    override fun KtfxPane.child2(): Sphere = sphere()

    override fun KtfxPane.child3(): Sphere = sphere { }

    override fun Sphere.testDefaultValues() {
        assertEquals(1.0, radius)
        assertEquals(64, divisions)
    }
}
