package ktfx.styles

import javafx.geometry.Side
import javafx.scene.paint.Color

interface AxisStyleBuilder {

    var side: Side

    var tickLength: Number

    @Incubating
    var tickLabelFont: String

    var tickLabelFill: Color

    var tickLabelGap: Number

    var tickMarkVisible: Boolean

    var tickLabelsVisible: Boolean
}

@Suppress("ClassName")
open class _AxisStyleBuilder(prettyPrint: Boolean) : _ChartStyleBuilder(prettyPrint), AxisStyleBuilder {
    override var side: Side by map
    override var tickLength: Number by map
    override var tickLabelFont: String by map
    override var tickLabelFill: Color by map
    override var tickLabelGap: Number by map
    override var tickMarkVisible: Boolean by map
    override var tickLabelsVisible: Boolean by map
}

inline fun axisStyle(
    prettyPrint: Boolean = false,
    builder: AxisStyleBuilder.() -> Unit
): String = _AxisStyleBuilder(prettyPrint).apply(builder).toString()