package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.PlusMinusSlider

class PlusMinusSliderTest : LayoutsStyledTest<KtfxPane, PlusMinusSlider>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = plusMinusSlider {}

    override fun KtfxPane.child2() = plusMinusSlider()

    override fun child3() = styledPlusMinusSlider()

    override fun KtfxPane.child4() = styledPlusMinusSlider()
}
