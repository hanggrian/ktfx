package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.Rating
import kotlin.test.assertEquals

class RatingTest : LayoutsTest<KtfxPane, Rating>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = rating { }
    override fun KtfxPane.child2() = rating()
    override fun KtfxPane.child3() = rating { }

    override fun Rating.testDefaultValues() {
        assertEquals(5, max)
        assertEquals(2.0, rating)
    }
}
