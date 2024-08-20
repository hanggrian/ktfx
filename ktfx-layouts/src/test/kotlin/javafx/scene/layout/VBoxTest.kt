package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import ktfx.controls.insetsOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class VBoxTest : LayoutsStyledTest<KtfxPane, VBox>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = vbox {}

    override fun KtfxPane.child2() = vbox()

    override fun child3() = styledVBox()

    override fun KtfxPane.child4() = styledVBox()

    override fun VBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }

    @Test
    fun vgrow() {
        vbox {
            val region = region()

            region.vgrow()
            assertEquals(Priority.ALWAYS, region.vgrow)
            region.clearConstraints()

            region.vgrow(false)
            assertEquals(Priority.NEVER, region.vgrow)
            region.clearConstraints()

            region.vgrow = Priority.SOMETIMES
            assertEquals(Priority.SOMETIMES, region.vgrow)
            region.clearConstraints()

            assertNull(region.vgrow)
        }
    }

    @Test
    fun margin() {
        vbox {
            val region = region()

            region.margin(insetsOf(1.0))
            assertEquals(1.0, region.margin!!.top)
            assertEquals(1.0, region.margin!!.right)
            assertEquals(1.0, region.margin!!.bottom)
            assertEquals(1.0, region.margin!!.left)
            region.clearConstraints()

            region.margin = insetsOf(2.0)
            assertEquals(2.0, region.margin!!.top)
            assertEquals(2.0, region.margin!!.right)
            assertEquals(2.0, region.margin!!.bottom)
            assertEquals(2.0, region.margin!!.left)
            region.clearConstraints()

            assertNull(region.margin)
        }
    }
}
