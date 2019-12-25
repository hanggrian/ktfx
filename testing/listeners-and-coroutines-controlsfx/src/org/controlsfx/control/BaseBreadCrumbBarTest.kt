package ktfx.controlsfx.test

import ktfx.test.initToolkit
import org.controlsfx.control.BreadCrumbBar
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseBreadCrumbBarTest() {

    abstract fun <E> BreadCrumbBar<E>.callOnCrumbAction(action: (BreadCrumbBar.BreadCrumbActionEvent<E>) -> Unit)

    private lateinit var crumbBar: BreadCrumbBar<String>

    @BeforeTest fun create() {
        initToolkit()
        crumbBar = BreadCrumbBar()
    }

    @Test fun onCrumbAction() {
        crumbBar.callOnCrumbAction {
            assertEquals("Hello world", it.selectedCrumb.value)
        }
        crumbBar.onCrumbAction.handle(BreadCrumbBar.BreadCrumbActionEvent(BreadCrumbBar.buildTreeModel("Hello world")))
    }
}