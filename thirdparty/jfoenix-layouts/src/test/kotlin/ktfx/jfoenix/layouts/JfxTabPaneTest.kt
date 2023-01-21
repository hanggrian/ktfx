package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXTabPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.tab
import kotlin.test.Test
import kotlin.test.assertEquals

class JfxTabPaneTest : LayoutsTest<KtfxPane, JFXTabPane>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXTabPane = jfxTabPane { }
    override fun KtfxPane.child2(): JFXTabPane = jfxTabPane()
    override fun KtfxPane.child3(): JFXTabPane = jfxTabPane { }

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
