package ktfx.controlsfx.coroutines

import com.hanggrian.ktfx.test.initToolkit
import kotlinx.coroutines.Dispatchers
import org.controlsfx.control.BreadCrumbBar
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class BreadCrumbBarTest {
    private lateinit var crumbBar: BreadCrumbBar<String>

    @BeforeTest
    fun create() {
        initToolkit()
        crumbBar = BreadCrumbBar()
    }

    @Test
    fun onCrumbAction() {
        crumbBar.onCrumbAction(Dispatchers.Unconfined) {
            assertEquals("Hello world", it.selectedCrumb.value)
        }
        crumbBar.onCrumbAction.handle(
            BreadCrumbBar.BreadCrumbActionEvent(BreadCrumbBar.buildTreeModel("Hello world")),
        )
    }
}
