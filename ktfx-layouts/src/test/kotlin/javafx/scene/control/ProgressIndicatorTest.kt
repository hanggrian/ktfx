package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator
import kotlin.test.assertEquals

class ProgressIndicatorTest : LayoutsStyledTest<KtfxPane, ProgressIndicator>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = progressIndicator {}

    override fun KtfxPane.child2() = progressIndicator()

    override fun child3() = styledProgressIndicator(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledProgressIndicator(styleClass = arrayOf("style"))

    override fun ProgressIndicator.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}
