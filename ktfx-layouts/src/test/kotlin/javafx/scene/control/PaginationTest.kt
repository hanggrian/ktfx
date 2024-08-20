package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Pagination
import kotlin.test.assertEquals

class PaginationTest : LayoutsStyledTest<KtfxPane, Pagination>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = pagination {}

    override fun KtfxPane.child2() = pagination()

    override fun child3() = styledPagination()

    override fun KtfxPane.child4() = styledPagination()

    override fun Pagination.testDefaultValues() {
        assertEquals(Pagination.INDETERMINATE, pageCount)
        assertEquals(0, currentPageIndex)
    }
}
