package ktfx.layouts

import javafx.geometry.Orientation
import javafx.scene.control.Separator
import ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SeparatorTest : LayoutsTest<KtfxPane, Separator>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = separator { }
    override fun KtfxPane.child2() = separator()
    override fun KtfxPane.child3() = separator { }

    @Test fun verticalSeparator() {
        verticalSeparator {
            assertEquals(Orientation.VERTICAL, orientation)
        }
    }
}