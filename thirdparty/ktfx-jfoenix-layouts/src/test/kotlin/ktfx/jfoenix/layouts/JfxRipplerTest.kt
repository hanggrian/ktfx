package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXRippler
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import kotlin.test.Test
import kotlin.test.assertIs

class JfxRipplerTest : LayoutsStyledTest<KtfxPane, JFXRippler>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxRippler {}

    override fun KtfxPane.child2() = jfxRippler()

    override fun child3() = styledJfxRippler()

    override fun KtfxPane.child4() = styledJfxRippler()

    @Test
    fun add() {
        jfxRippler {
            region()
            assertIs<Region>(children.single())
        }
    }
}
