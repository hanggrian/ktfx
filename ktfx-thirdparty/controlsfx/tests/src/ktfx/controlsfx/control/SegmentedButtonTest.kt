package ktfx.controlsfx.control

import ktfx.controlsfx.segmentedButton
import ktfx.layouts.toggleButton
import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertEquals

class SegmentedButtonTest : ToolkitLayoutTest() {

    override fun newInstance() {
        assertEquals(segmentedButton {
            toggleButton("Hello")
        }.buttons.size, 1)
    }

    override fun withManager() {
    }
}