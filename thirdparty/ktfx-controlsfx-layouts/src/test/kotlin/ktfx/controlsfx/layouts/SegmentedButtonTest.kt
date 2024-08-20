package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import ktfx.layouts.toggleButton
import org.controlsfx.control.SegmentedButton
import kotlin.test.Test
import kotlin.test.assertEquals

class SegmentedButtonTest : LayoutsStyledTest<KtfxPane, SegmentedButton>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = segmentedButton {}

    override fun KtfxPane.child2() = segmentedButton()

    override fun child3() = styledSegmentedButton()

    override fun KtfxPane.child4() = styledSegmentedButton()

    @Test
    fun stringInvocation() {
        segmentedButton {
            toggleButton("Hello")
            "World" {
            }
            assertEquals(2, buttons.size)
        }
    }
}
