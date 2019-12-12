package ktfx.layouts.scene.control

import javafx.scene.control.Pagination
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.pagination
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class PaginationTest : BaseLayoutTest<NodeManager, Pagination>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = pagination { }
    override fun NodeManager.child2() = pagination()
    override fun NodeManager.child3() = pagination { }

    override fun Pagination.testDefaultValues() {
        assertEquals(Pagination.INDETERMINATE, pageCount)
        assertEquals(0, currentPageIndex)
    }
}