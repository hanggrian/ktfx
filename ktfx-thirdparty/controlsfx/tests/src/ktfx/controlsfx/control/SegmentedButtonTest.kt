package ktfx.controlsfx.control

import ktfx.controlsfx.segmentedButton
import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.layouts.toggleButton
import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertEquals

class SegmentedButtonTest : ToolkitLayoutTest<NodeManager>(_Pane()) {

    override fun test() {
        manage {
            assertEquals(segmentedButton {
                toggleButton("Hello")
            }.buttons.size, 1)
        }
    }
}