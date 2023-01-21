package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ProgressBar
import kotlin.test.assertEquals

class ProgressBarTest : LayoutsTest<KtfxPane, ProgressBar>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): ProgressBar = progressBar { }
    override fun KtfxPane.child2(): ProgressBar = progressBar()
    override fun KtfxPane.child3(): ProgressBar = progressBar { }

    override fun ProgressBar.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}
