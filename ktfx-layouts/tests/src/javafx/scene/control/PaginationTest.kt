package ktfx.layouts

import javafx.scene.control.Pagination
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class PaginationTest : LayoutTest<NodeManager, Pagination>() {

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