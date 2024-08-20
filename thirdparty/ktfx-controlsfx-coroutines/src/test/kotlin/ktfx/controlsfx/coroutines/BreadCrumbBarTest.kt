package ktfx.controlsfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.stage.Stage
import org.controlsfx.control.BreadCrumbBar
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class BreadCrumbBarTest : ApplicationTest() {
    private lateinit var crumbBar: BreadCrumbBar<String>

    override fun start(stage: Stage) {
        stage.testScene<BreadCrumbBar<*>>()
        crumbBar = BreadCrumbBar<String>()
    }

    @Test
    fun onCrumbAction() {
        interact {
            crumbBar.onCrumbAction {
                assertEquals("Hello World", it.selectedCrumb.value)
            }
            crumbBar.onCrumbAction.handle(
                BreadCrumbBar.BreadCrumbActionEvent(BreadCrumbBar.buildTreeModel("Hello World")),
            )
        }
    }
}
