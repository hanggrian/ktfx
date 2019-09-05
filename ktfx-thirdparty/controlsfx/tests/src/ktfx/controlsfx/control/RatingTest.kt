package ktfx.controlsfx.control

import ktfx.controlsfx.rating
import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertEquals

class RatingTest : ToolkitLayoutTest<NodeManager>(_Pane()) {

    override fun test() {
        manage {
            assertEquals(rating {}.max, 5)
        }
    }
}