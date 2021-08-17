package ktfx.controlsfx.test

import com.hendraanggrian.ktfx.test.FakeEventTarget
import com.hendraanggrian.ktfx.test.initToolkit
import org.controlsfx.control.PlusMinusSlider
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BasePlusMinusSliderTest {
    private lateinit var slider: PlusMinusSlider

    abstract fun PlusMinusSlider.callOnValueChanged(action: (PlusMinusSlider.PlusMinusEvent) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        slider = PlusMinusSlider()
    }

    @Test
    fun onValueChanged() {
        slider.callOnValueChanged {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(PlusMinusSlider.PlusMinusEvent.VALUE_CHANGED, it.eventType)
            assertEquals(0.0, it.value)
        }
        slider.onValueChanged.handle(
            PlusMinusSlider.PlusMinusEvent(this, FakeEventTarget, PlusMinusSlider.PlusMinusEvent.VALUE_CHANGED, 0.0)
        )
    }
}
