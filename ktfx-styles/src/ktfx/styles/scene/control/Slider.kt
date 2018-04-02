package ktfx.styles

import javafx.geometry.Orientation
import ktfx.styles.internal._SliderStyleBuilder

interface SliderStyleBuilder {

    var orientation: Orientation

    var showTickLabels: Boolean

    var showTickMarks: Boolean

    var majorTickUnit: Number

    var minorTickCount: Int

    var snapToTicks: Boolean

    var blockIncrement: Int
}

inline fun sliderStyle(
    prettyPrint: Boolean = false,
    builder: SliderStyleBuilder .() -> Unit
): String = _SliderStyleBuilder(prettyPrint).apply(builder).toString()