package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSpinner
import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class JFXSpinnerTest : LayoutsTest<KtfxPane, JFXSpinner>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxSpinner { }
    override fun KtfxPane.child2() = jfxSpinner()
    override fun KtfxPane.child3() = jfxSpinner { }

    override fun JFXSpinner.testDefaultValues() {
        assertEquals(JFXSpinner.INDETERMINATE_PROGRESS, progress)
    }
}