package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTabPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.tab
import kotlin.test.Test
import kotlin.test.assertEquals

class JfxTabPaneTest : LayoutsStyledTest<KtfxPane, JFXTabPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTabPane {}

    override fun KtfxPane.child2() = jfxTabPane()

    override fun child3() = styledJfxTabPane()

    override fun KtfxPane.child4() = styledJfxTabPane()

    @Test
    fun stringInvocation() {
        jfxTabPane {
            tab("Tab 1")
            "Tab 2" {
            }
            assertEquals(2, tabs.size)
        }
    }
}
