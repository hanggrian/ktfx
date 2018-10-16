package ktfx.controlsfx

import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertEquals

class RatingTest : ToolkitLayoutTest() {

    override fun newInstance() {
        assertEquals(rating {}.max, 5)
    }

    override fun withManager() {
    }
}