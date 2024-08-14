package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.Rating
import kotlin.test.assertEquals

class RatingTest : LayoutsStyledTest<KtfxPane, Rating>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = rating {}

    override fun KtfxPane.child2() = rating()

    override fun child3() = styledRating(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledRating(styleClass = arrayOf("style"))

    override fun Rating.testDefaultValues() {
        assertEquals(5, max)
        assertEquals(2.0, rating)
    }
}
