package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.geometry.Side
import ktfx.layouts.KtfxPane
import ktfx.layouts.pane
import org.controlsfx.control.MasterDetailPane
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class MasterDetailPaneTest : LayoutsTest<KtfxPane, MasterDetailPane>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): MasterDetailPane = masterDetailPane { }

    override fun KtfxPane.child2(): MasterDetailPane = masterDetailPane()

    override fun KtfxPane.child3(): MasterDetailPane = masterDetailPane { }

    override fun MasterDetailPane.testDefaultValues() {
        assertEquals(Side.RIGHT, detailSide)
        assertTrue(isShowDetailNode)
    }

    @Test
    fun illegalThirdNode() {
        assertFailsWith<IllegalStateException> {
            masterDetailPane {
                pane()
                pane()
                pane()
            }
        }
    }
}
