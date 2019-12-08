package ktfx.controlsfx.layouts

import javafx.geometry.Side
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.pane
import ktfx.test.LayoutTest
import org.controlsfx.control.MasterDetailPane
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class MasterDetailPaneTest : LayoutTest<NodeManager, MasterDetailPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = masterDetailPane { }
    override fun NodeManager.child2() = masterDetailPane()
    override fun NodeManager.child3() = masterDetailPane { }

    override fun MasterDetailPane.testDefaultValues() {
        assertEquals(Side.RIGHT, detailSide)
        assertTrue(isShowDetailNode)
    }

    @Test fun illegalThirdNode() {
        assertFailsWith<IllegalStateException> {
            masterDetailPane {
                pane()
                pane()
                pane()
            }
        }
    }
}