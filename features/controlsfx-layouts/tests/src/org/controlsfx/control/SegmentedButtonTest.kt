package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.toggleButton
import ktfx.test.LayoutTest
import org.controlsfx.control.SegmentedButton
import kotlin.test.Test
import kotlin.test.assertEquals

class SegmentedButtonTest : LayoutTest<NodeManager, SegmentedButton>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = segmentedButton { }
    override fun NodeManager.child2() = segmentedButton()
    override fun NodeManager.child3() = segmentedButton { }

    @Test fun stringInvocation() {
        segmentedButton {
            toggleButton("Hello")
            "World" {
            }
            assertEquals(2, buttons.size)
        }
    }
}