package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.toggleButton
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertEquals

class SegmentedButtonTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        assertEquals(1, segmentedButton {
            toggleButton("Hello")
        }.buttons.size)
    }
}