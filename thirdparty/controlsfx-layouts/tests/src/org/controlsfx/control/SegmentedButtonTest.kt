package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.toggleButton
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.SegmentedButton
import kotlin.test.Test
import kotlin.test.assertEquals

class SegmentedButtonTest : LayoutsTest<KtfxPane, SegmentedButton>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = segmentedButton { }
    override fun KtfxPane.child2() = segmentedButton()
    override fun KtfxPane.child3() = segmentedButton { }

    @Test fun stringInvocation() {
        segmentedButton {
            toggleButton("Hello")
            "World" {
            }
            assertEquals(2, buttons.size)
        }
    }
}