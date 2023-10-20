package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.Rating
import kotlin.test.assertEquals

class RatingTest : LayoutsTest<KtfxPane, Rating>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Rating = rating { }

    override fun KtfxPane.child2(): Rating = rating()

    override fun KtfxPane.child3(): Rating = rating { }

    override fun Rating.testDefaultValues() {
        assertEquals(5, max)
        assertEquals(2.0, rating)
    }
}
