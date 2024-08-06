package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXSpinner
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxSpinnerTest : LayoutsTest<KtfxPane, JFXSpinner>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXSpinner = jfxSpinner { }

    override fun KtfxPane.child2(): JFXSpinner = jfxSpinner()

    override fun KtfxPane.child3(): JFXSpinner = jfxSpinner { }

    override fun JFXSpinner.testDefaultValues() {
        assertEquals(JFXSpinner.INDETERMINATE_PROGRESS, progress)
    }
}
