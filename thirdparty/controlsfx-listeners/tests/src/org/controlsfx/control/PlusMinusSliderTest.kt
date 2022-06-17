package ktfx.controlsfx.listeners

import ktfx.controlsfx.test.BasePlusMinusSliderTest
import org.controlsfx.control.PlusMinusSlider

class PlusMinusSliderTest : BasePlusMinusSliderTest() {

    override fun PlusMinusSlider.callOnValueChanged(action: (PlusMinusSlider.PlusMinusEvent) -> Unit) =
        onValueChanged(action)
}
