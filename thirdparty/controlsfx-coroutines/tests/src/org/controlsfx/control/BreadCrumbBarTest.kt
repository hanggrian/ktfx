package ktfx.controlsfx.coroutines

import kotlinx.coroutines.Dispatchers
import ktfx.controlsfx.test.BaseBreadCrumbBarTest
import org.controlsfx.control.BreadCrumbBar

class BreadCrumbBarTest : BaseBreadCrumbBarTest() {

    override fun <E> BreadCrumbBar<E>.callOnCrumbAction(action: (BreadCrumbBar.BreadCrumbActionEvent<E>) -> Unit) =
        onCrumbAction(Dispatchers.Unconfined) { action(it) }
}
