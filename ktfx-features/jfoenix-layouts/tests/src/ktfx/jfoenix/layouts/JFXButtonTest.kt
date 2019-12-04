package ktfx.jfoenix.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertNull

class JFXButtonTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        assertNull(jfxButton().text)
    }
}