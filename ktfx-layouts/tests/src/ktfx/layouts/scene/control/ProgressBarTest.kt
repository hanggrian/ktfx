package ktfx.layouts.scene.control

import javafx.scene.control.ProgressBar
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.progressBar
import kotlin.test.assertEquals

class ProgressBarTest : LayoutTest<NodeManager, ProgressBar>() {

    override fun createManager() = KtfxPane()
    override fun create() = progressBar { }
    override fun NodeManager.add() = progressBar()
    override fun NodeManager.addWithBuilder() = progressBar { }

    override fun ProgressBar.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}