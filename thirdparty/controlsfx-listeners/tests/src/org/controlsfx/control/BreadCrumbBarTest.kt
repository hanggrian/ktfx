package ktfx.controlsfx.listeners

import ktfx.controlsfx.test.BaseBreadCrumbBarTest
import org.controlsfx.control.BreadCrumbBar

class BreadCrumbBarTest : BaseBreadCrumbBarTest() {

    override fun <E> BreadCrumbBar<E>.callOnCrumbAction(action: (BreadCrumbBar.BreadCrumbActionEvent<E>) -> Unit) =
        onCrumbAction(action)
}