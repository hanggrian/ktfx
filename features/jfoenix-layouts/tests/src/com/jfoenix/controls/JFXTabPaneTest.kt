package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTabPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.tab
import ktfx.test.LayoutTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JFXTabPaneTest : LayoutTest<NodeManager, JFXTabPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxTabPane { }
    override fun NodeManager.child2() = jfxTabPane()
    override fun NodeManager.child3() = jfxTabPane { }

    @Test fun stringInvocation() {
        jfxTabPane {
            tab("Tab 1")
            "Tab 2" {
            }
            assertEquals(2, tabs.size)
        }
    }
}