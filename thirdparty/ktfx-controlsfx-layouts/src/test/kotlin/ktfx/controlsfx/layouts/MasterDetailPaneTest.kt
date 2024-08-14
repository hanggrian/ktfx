package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.geometry.Side
import ktfx.layouts.KtfxPane
import ktfx.layouts.pane
import org.controlsfx.control.MasterDetailPane
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class MasterDetailPaneTest : LayoutsStyledTest<KtfxPane, MasterDetailPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = masterDetailPane {}

    override fun KtfxPane.child2() = masterDetailPane()

    override fun child3() = styledMasterDetailPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledMasterDetailPane(styleClass = arrayOf("style"))

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
