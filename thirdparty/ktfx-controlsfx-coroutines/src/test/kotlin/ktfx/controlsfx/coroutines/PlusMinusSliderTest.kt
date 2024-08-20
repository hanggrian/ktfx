package ktfx.controlsfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.stage.Stage
import org.controlsfx.control.PlusMinusSlider
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PlusMinusSliderTest : ApplicationTest() {
    private lateinit var slider: PlusMinusSlider

    override fun start(stage: Stage) {
        stage.testScene<PlusMinusSlider>()
        slider = PlusMinusSlider()
    }

    @Test
    fun onValueChanged() {
        interact {
            slider.onValueChanged {
                assertEquals(this@PlusMinusSliderTest, it.source)
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
}
