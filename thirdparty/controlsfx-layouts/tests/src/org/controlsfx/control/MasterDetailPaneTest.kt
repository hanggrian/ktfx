package ktfx.controlsfx.layouts

import javafx.geometry.Side
import ktfx.layouts.KtfxPane
import ktfx.layouts.pane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.MasterDetailPane
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class MasterDetailPaneTest : LayoutsTest<KtfxPane, MasterDetailPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = masterDetailPane { }
    override fun KtfxPane.child2() = masterDetailPane()
    override fun KtfxPane.child3() = masterDetailPane { }

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