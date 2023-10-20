package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Pagination
import kotlin.test.assertEquals

class PaginationTest : LayoutsTest<KtfxPane, Pagination>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Pagination = pagination { }

    override fun KtfxPane.child2(): Pagination = pagination()

    override fun KtfxPane.child3(): Pagination = pagination { }

    override fun Pagination.testDefaultValues() {
        assertEquals(Pagination.INDETERMINATE, pageCount)
        assertEquals(0, currentPageIndex)
    }
}
