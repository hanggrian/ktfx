package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.PlusMinusSlider

class PlusMinusSliderTest : LayoutsTest<KtfxPane, PlusMinusSlider>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): PlusMinusSlider = plusMinusSlider { }

    override fun KtfxPane.child2(): PlusMinusSlider = plusMinusSlider()

    override fun KtfxPane.child3(): PlusMinusSlider = plusMinusSlider { }
}
