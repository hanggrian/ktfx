package ktfx.layouts

import javafx.scene.control.Pagination
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class PaginationTest : LayoutsTest<KtfxPane, Pagination>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = pagination { }
    override fun KtfxPane.child2() = pagination()
    override fun KtfxPane.child3() = pagination { }

    override fun Pagination.testDefaultValues() {
        assertEquals(Pagination.INDETERMINATE, pageCount)
        assertEquals(0, currentPageIndex)
    }
}