package ktfx.styles.scene.control

import javafx.geometry.Orientation.VERTICAL
import javafx.scene.control.Slider
import ktfx.styles.NodeTest
import ktfx.styles.sliderStyle
import kotlin.test.assertEquals

class SliderStyleTest : NodeTest<Slider>() {

    override fun newInstance() = Slider(0.0, 100.0, 50.0)

    override val style: String
        get() = sliderStyle {
            orientation = VERTICAL
            /*showTickLabels = true
            showTickMarks = true
            majorTickUnit = 50
            minorTickCount = 6
            snapToTicks = true
            blockIncrement = 20*/
        }

    override fun Slider.assertion() {
        assertEquals(orientation, VERTICAL)
        /*assertEquals(isShowTickLabels, true)
        assertEquals(isShowTickMarks, true)
        assertEquals(majorTickUnit, 50.0)
        assertEquals(minorTickCount, 6)
        assertEquals(isSnapToTicks, true)
        assertEquals(blockIncrement, 20.0)*/
    }
}