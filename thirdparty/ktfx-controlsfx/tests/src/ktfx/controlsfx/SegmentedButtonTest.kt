package ktfx.controlsfx

import ktfx.layouts.button
import ktfx.test.PlatformLayoutTest
import kotlin.test.assertEquals

class SegmentedButtonTest : PlatformLayoutTest() {

    override fun newInstance() {
        assertEquals(segmentedButton {
            button("Hello")
        }.buttons.size, 1)
    }

    override fun withManager() {
    }
}