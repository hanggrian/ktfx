package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest
import org.controlsfx.control.HiddenSidesPane

class HiddenSidesPaneTest : LayoutsTest<KtfxPane, HiddenSidesPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = hiddenSidesPane { }
    override fun KtfxPane.child2() = hiddenSidesPane()
    override fun KtfxPane.child3() = hiddenSidesPane { }
}