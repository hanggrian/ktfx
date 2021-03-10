package ktfx.layouts

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class ProgressIndicatorTest : LayoutsTest<KtfxPane, ProgressIndicator>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = progressIndicator { }
    override fun KtfxPane.child2() = progressIndicator()
    override fun KtfxPane.child3() = progressIndicator { }

    override fun ProgressIndicator.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}