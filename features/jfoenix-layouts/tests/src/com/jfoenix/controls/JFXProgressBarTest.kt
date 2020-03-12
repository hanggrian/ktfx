package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXProgressBar
import javafx.scene.control.ProgressBar
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class JFXProgressBarTest : LayoutsTest<KtfxPane, JFXProgressBar>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxProgressBar { }
    override fun KtfxPane.child2() = jfxProgressBar()
    override fun KtfxPane.child3() = jfxProgressBar { }

    override fun JFXProgressBar.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}