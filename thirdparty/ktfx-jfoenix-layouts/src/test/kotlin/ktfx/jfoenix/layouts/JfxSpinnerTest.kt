package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXSpinner
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxSpinnerTest : LayoutsStyledTest<KtfxPane, JFXSpinner>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxSpinner {}

    override fun KtfxPane.child2() = jfxSpinner()

    override fun child3() = styledJfxSpinner(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxSpinner(styleClass = arrayOf("style"))

    override fun JFXSpinner.testDefaultValues() {
        assertEquals(JFXSpinner.INDETERMINATE_PROGRESS, progress)
    }
}
