package ktfx.styles

import javafx.geometry.Side
import javafx.scene.paint.Color

open class AxisStyleBuilder : ChartStyleBuilder() {

    var side: Side by map

    var tickLength: Number by map

    @Incubating
    var tickLabelFont: String by map

    var tickLabelFill: Color by map

    var tickLabelGap: Number by map

    var tickMarkVisible: Boolean by map

    var tickLabelsVisible: Boolean by map
}

inline fun axisStyle(builder: AxisStyleBuilder.() -> Unit): String =
    AxisStyleBuilder().apply(builder).toString()