package ktfx.styles.scene.control

import javafx.scene.control.Pagination
import ktfx.styles.NodeTest
import ktfx.styles.paginationStyle

class PaginationStyleTest : NodeTest<Pagination>() {

    override fun newInstance() = Pagination()

    override val style: String
        get() = paginationStyle {
            // maxPageIndicatorCount = 20
            // arrowsVisible = false
            // tooltipVisible = false
            // pageInformationVisible = false
            // pageInformationAlignment = RIGHT
        }

    override fun Pagination.assertion() {
        // assertEquals(maxPageIndicatorCount, 20)
    }
}