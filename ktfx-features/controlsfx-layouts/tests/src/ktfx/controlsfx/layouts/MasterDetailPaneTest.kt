package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.pane
import ktfx.testing.LayoutToolkitTest
import kotlin.test.assertFailsWith

class MasterDetailPaneTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        assertFailsWith<IllegalStateException> {
            masterDetailPane {
                pane()
                pane()
                pane()
            }
        }
    }
}