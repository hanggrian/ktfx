package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.HiddenSidesPane

class HiddenSidesPaneTest : LayoutsStyledTest<KtfxPane, HiddenSidesPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = hiddenSidesPane {}

    override fun KtfxPane.child2() = hiddenSidesPane()

    override fun child3() = styledHiddenSidesPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledHiddenSidesPane(styleClass = arrayOf("style"))
}
