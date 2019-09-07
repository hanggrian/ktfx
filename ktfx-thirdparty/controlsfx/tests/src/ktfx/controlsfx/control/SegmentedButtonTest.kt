package ktfx.controlsfx.control

import ktfx.controlsfx.segmentedButton
import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.layouts.toggleButton
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertEquals

class SegmentedButtonTest : LayoutToolkitTest<NodeManager>(_Pane()) {

    override fun NodeManager.layout() {
        assertEquals(segmentedButton {
            toggleButton("Hello")
        }.buttons.size, 1)
    }
}