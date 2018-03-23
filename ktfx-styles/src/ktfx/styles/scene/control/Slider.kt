package ktfx.styles

import javafx.geometry.Orientation

class SliderStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var orientation: Orientation by map

    var showTickLabels: Boolean by map

    var showTickMarks: Boolean by map

    var majorTickUnit: Number by map

    var minorTickCount: Int by map

    var snapToTicks: Boolean by map

    var blockIncrement: Int by map
}

inline fun sliderStyle(
    prettyPrint: Boolean = false,
    builder: SliderStyleBuilder .() -> Unit
): String = SliderStyleBuilder(prettyPrint).apply(builder).toString()