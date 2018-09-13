package javafxx.layouts.controlsfx

import javafxx.test.PlatformLayoutTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SegmentedButtonTest : PlatformLayoutTest() {

    override fun newInstance() {
        assertTrue(segmentedButton().buttons.isEmpty())
    }

    override fun newInstanceInitialized() {
        assertEquals(segmentedButton {
            "Hello"()
        }.buttons.size, 1)
    }

    override fun withManager() {
    }

    override fun withManagerInitialized() {
    }
}