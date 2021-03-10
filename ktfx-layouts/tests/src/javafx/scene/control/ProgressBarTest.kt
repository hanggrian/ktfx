package ktfx.layouts

import javafx.scene.control.ProgressBar
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class ProgressBarTest : LayoutsTest<KtfxPane, ProgressBar>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = progressBar { }
    override fun KtfxPane.child2() = progressBar()
    override fun KtfxPane.child3() = progressBar { }

    override fun ProgressBar.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}