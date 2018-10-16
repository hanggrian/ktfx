package ktfx.controlsfx

import ktfx.layouts.button
import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertEquals

class SegmentedButtonTest : ToolkitLayoutTest() {

    override fun newInstance() {
        assertEquals(segmentedButton {
            button("Hello")
        }.buttons.size, 1)
    }

    override fun withManager() {
    }
}