package javafxx.layouts.jfoenix

import javafxx.test.PlatformLayoutTest
import kotlin.test.assertNull

class JFXButtonTest : PlatformLayoutTest() {

    override fun newInstance() {
        assertNull(jfxButton().text)
    }

    override fun newInstanceInitialized() {
        jfxButton {
        }
    }

    override fun withManager() {
    }

    override fun withManagerInitialized() {
    }
}