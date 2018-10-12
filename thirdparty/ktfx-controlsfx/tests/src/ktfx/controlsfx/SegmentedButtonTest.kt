package ktfx.controlsfx

import ktfx.layouts.button
import ktfx.test.PlatformLayoutTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SegmentedButtonTest : PlatformLayoutTest() {

    override fun newInstance() {
        assertTrue(segmentedButton().buttons.isEmpty())
    }

    override fun newInstanceInitialized() {
        assertEquals(segmentedButton {
            button("Hello")
        }.buttons.size, 1)
    }

    override fun withManager() {
    }

    override fun withManagerInitialized() {
    }
}