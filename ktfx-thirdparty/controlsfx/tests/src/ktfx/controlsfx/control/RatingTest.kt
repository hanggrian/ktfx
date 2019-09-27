package ktfx.controlsfx.control

import ktfx.controlsfx.rating
import ktfx.layouts.NodeManager
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertEquals

class RatingTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        assertEquals(rating {}.max, 5)
    }
}