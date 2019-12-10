package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import org.controlsfx.control.Rating
import kotlin.test.assertEquals

class RatingTest : LayoutTest<NodeManager, Rating>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = rating { }
    override fun NodeManager.child2() = rating()
    override fun NodeManager.child3() = rating { }

    override fun Rating.testDefaultValues() {
        assertEquals(5, max)
        assertEquals(2.0, rating)
    }
}