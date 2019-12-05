package ktfx.layouts.scene.control

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.progressIndicator
import kotlin.test.assertEquals

class ProgressIndicatorTest : LayoutTest<NodeManager, ProgressIndicator>() {

    override fun createManager() = KtfxPane()
    override fun create() = progressIndicator { }
    override fun NodeManager.add() = progressIndicator()
    override fun NodeManager.addWithBuilder() = progressIndicator { }

    override fun ProgressIndicator.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}