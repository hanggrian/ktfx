package ktfx.jfoenix

import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertNull

class JFXButtonTest : ToolkitLayoutTest() {

    override fun newInstance() {
        assertNull(jfxButton().text)
    }

    override fun withManager() {
    }
}