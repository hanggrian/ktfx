package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXProgressBar
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class JFXProgressBarTest : LayoutsTest<NodeManager, JFXProgressBar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxProgressBar { }
    override fun NodeManager.child2() = jfxProgressBar()
    override fun NodeManager.child3() = jfxProgressBar { }

    override fun JFXProgressBar.testDefaultValues() {
        assertEquals(0.0, progress)
    }
}