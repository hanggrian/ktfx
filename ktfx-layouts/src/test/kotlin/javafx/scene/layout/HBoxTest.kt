package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import ktfx.controls.insetsOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class HBoxTest : LayoutsStyledTest<KtfxPane, HBox>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = hbox {}

    override fun KtfxPane.child2() = hbox()

    override fun child3() = styledHBox()

    override fun KtfxPane.child4() = styledHBox()

    override fun HBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }

    @Test
    fun hgrow() {
        hbox {
            val region = region()

            region.hgrow()
            assertEquals(Priority.ALWAYS, region.hgrow)
            region.clearConstraints()

            region.hgrow(false)
            assertEquals(Priority.NEVER, region.hgrow)
            region.clearConstraints()

            region.hgrow = Priority.SOMETIMES
            assertEquals(Priority.SOMETIMES, region.hgrow)
            region.clearConstraints()

            assertNull(region.hgrow)
        }
    }

    @Test
    fun margin() {
        hbox {
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
