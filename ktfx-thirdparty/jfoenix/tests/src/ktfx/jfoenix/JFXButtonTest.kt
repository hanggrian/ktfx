package ktfx.jfoenix

import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertNull

class JFXButtonTest : ToolkitLayoutTest<NodeManager>(_Pane()) {

    override fun test() {
        manage {
            assertNull(jfxButton().text)
        }
    }
}