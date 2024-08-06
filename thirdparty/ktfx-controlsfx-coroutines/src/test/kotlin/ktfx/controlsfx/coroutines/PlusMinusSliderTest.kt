package ktfx.controlsfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import kotlinx.coroutines.Dispatchers
import org.controlsfx.control.PlusMinusSlider
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PlusMinusSliderTest {
    private lateinit var slider: PlusMinusSlider

    @BeforeTest
    fun start() {
        initToolkit()
        slider = PlusMinusSlider()
    }

    @Test
    fun onValueChanged() {
        slider.onValueChanged(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(PlusMinusSlider.PlusMinusEvent.VALUE_CHANGED, it.eventType)
            assertEquals(0.0, it.value)
        }
        slider.onValueChanged.handle(
            PlusMinusSlider.PlusMinusEvent(
                this,
                FakeEventTarget,
                PlusMinusSlider.PlusMinusEvent.VALUE_CHANGED,
                0.0,
            ),
        )
    }
}
