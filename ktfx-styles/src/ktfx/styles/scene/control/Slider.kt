package ktfx.styles

import javafx.geometry.Orientation

interface SliderStyleBuilder {

    var orientation: Orientation

    var showTickLabels: Boolean

    var showTickMarks: Boolean

    var majorTickUnit: Number

    var minorTickCount: Int

    var snapToTicks: Boolean

    var blockIncrement: Int
}

@PublishedApi
@Suppress("ClassName")
internal class _SliderStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint), SliderStyleBuilder {
    override var orientation: Orientation by map
    override var showTickLabels: Boolean by map
    override var showTickMarks: Boolean by map
    override var majorTickUnit: Number by map
    override var minorTickCount: Int by map
    override var snapToTicks: Boolean by map
    override var blockIncrement: Int by map
}

inline fun sliderStyle(
    prettyPrint: Boolean = false,
    builder: SliderStyleBuilder .() -> Unit
): String = _SliderStyleBuilder(prettyPrint).apply(builder).toString()