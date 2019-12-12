package ktfx.layouts.scene.control

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.progressIndicator
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class ProgressIndicatorTest : BaseLayoutTest<NodeManager, ProgressIndicator>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = progressIndicator { }
    override fun NodeManager.child2() = progressIndicator()
    override fun NodeManager.child3() = progressIndicator { }

    override fun ProgressIndicator.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}