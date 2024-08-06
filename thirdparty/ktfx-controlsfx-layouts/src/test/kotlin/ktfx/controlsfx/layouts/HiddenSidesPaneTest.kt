package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.HiddenSidesPane

class HiddenSidesPaneTest : LayoutsTest<KtfxPane, HiddenSidesPane>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): HiddenSidesPane = hiddenSidesPane { }

    override fun KtfxPane.child2(): HiddenSidesPane = hiddenSidesPane()

    override fun KtfxPane.child3(): HiddenSidesPane = hiddenSidesPane { }
}
