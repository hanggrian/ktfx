package ktfx.jfoenix

import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertNull

class JFXButtonTest : LayoutToolkitTest<NodeManager>(_Pane()) {

    override fun NodeManager.layout() {
        assertNull(jfxButton().text)
    }
}