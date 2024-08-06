package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator
import kotlin.test.assertEquals

class ProgressIndicatorTest : LayoutsTest<KtfxPane, ProgressIndicator>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): ProgressIndicator = progressIndicator { }

    override fun KtfxPane.child2(): ProgressIndicator = progressIndicator()

    override fun KtfxPane.child3(): ProgressIndicator = progressIndicator { }

    override fun ProgressIndicator.testDefaultValues() {
        assertEquals(ProgressBar.INDETERMINATE_PROGRESS, progress)
    }
}
