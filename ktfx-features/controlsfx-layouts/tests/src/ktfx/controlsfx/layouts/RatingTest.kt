package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.testing.LayoutToolkitTest
import kotlin.test.assertEquals

class RatingTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        assertEquals(5, rating {}.max)
    }
}