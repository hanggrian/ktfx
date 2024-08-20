package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ProgressBar
import kotlin.test.assertEquals

class ProgressBarTest : LayoutsStyledTest<KtfxPane, ProgressBar>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = progressBar {}

    override fun KtfxPane.child2() = progressBar()

    override fun child3() = styledProgressBar()

    override fun KtfxPane.child4() = styledProgressBar()

    override fun ProgressBar.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}
