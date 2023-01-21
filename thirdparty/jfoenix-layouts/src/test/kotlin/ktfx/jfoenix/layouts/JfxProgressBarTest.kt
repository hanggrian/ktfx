package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXProgressBar
import javafx.scene.control.ProgressBar
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxProgressBarTest : LayoutsTest<KtfxPane, JFXProgressBar>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXProgressBar = jfxProgressBar { }
    override fun KtfxPane.child2(): JFXProgressBar = jfxProgressBar()
    override fun KtfxPane.child3(): JFXProgressBar = jfxProgressBar { }

    override fun JFXProgressBar.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}
