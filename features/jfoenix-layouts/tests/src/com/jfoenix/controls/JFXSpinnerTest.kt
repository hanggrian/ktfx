package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSpinner
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class JFXSpinnerTest : LayoutsTest<NodeManager, JFXSpinner>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxSpinner { }
    override fun NodeManager.child2() = jfxSpinner()
    override fun NodeManager.child3() = jfxSpinner { }

    override fun JFXSpinner.testDefaultValues() {
        assertEquals(JFXSpinner.INDETERMINATE_PROGRESS, progress)
    }
}