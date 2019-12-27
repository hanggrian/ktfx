package ktfx.layouts

import javafx.scene.control.ProgressBar
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class ProgressBarTest : LayoutsTest<NodeManager, ProgressBar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = progressBar { }
    override fun NodeManager.child2() = progressBar()
    override fun NodeManager.child3() = progressBar { }

    override fun ProgressBar.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}