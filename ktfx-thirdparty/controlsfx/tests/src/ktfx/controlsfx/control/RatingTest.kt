package ktfx.controlsfx.control

import ktfx.controlsfx.rating
import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertEquals

class RatingTest : LayoutToolkitTest<NodeManager>(_Pane()) {

    override fun NodeManager.layout() {
        assertEquals(rating {}.max, 5)
    }
}