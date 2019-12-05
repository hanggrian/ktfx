package ktfx.layouts.scene.control

import javafx.scene.control.Pagination
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.pagination
import kotlin.test.assertEquals

class PaginationTest : LayoutTest<NodeManager, Pagination>() {

    override fun createManager() = KtfxPane()
    override fun create() = pagination { }
    override fun NodeManager.add() = pagination()
    override fun NodeManager.addWithBuilder() = pagination { }

    override fun Pagination.testDefaultValues() {
        assertEquals(Pagination.INDETERMINATE, pageCount)
        assertEquals(0, currentPageIndex)
    }
}