package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.PlusMinusSlider

class PlusMinusSliderTest : LayoutsTest<KtfxPane, PlusMinusSlider>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = plusMinusSlider { }
    override fun KtfxPane.child2() = plusMinusSlider()
    override fun KtfxPane.child3() = plusMinusSlider { }
}