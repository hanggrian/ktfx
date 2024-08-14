package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXProgressBar
import javafx.scene.control.ProgressBar
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxProgressBarTest : LayoutsStyledTest<KtfxPane, JFXProgressBar>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxProgressBar {}

    override fun KtfxPane.child2() = jfxProgressBar()

    override fun child3() = styledJfxProgressBar(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxProgressBar(styleClass = arrayOf("style"))

    override fun JFXProgressBar.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}
