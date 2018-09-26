@file:Suppress("ClassName")

package ktfx.styles.internal

import javafx.geometry.Side
import javafx.scene.paint.Color
import ktfx.styles.AxisStyleBuilder
import ktfx.styles.CategoryAxisStyleBuilder
import ktfx.styles.ChartStyleBuilder
import ktfx.styles.LineChartStyleBuilder
import ktfx.styles.NumberAxisStyleBuilder
import ktfx.styles.PieChartStyleBuilder
import ktfx.styles.ValueAxisStyleBuilder
import ktfx.styles.XYChartStyleBuilder

open class _AxisStyleBuilder(
    prettyPrint: Boolean
) : _ChartStyleBuilder(prettyPrint), AxisStyleBuilder {
    override var side: Side by map
    override var tickLength: Number by map
    override var tickLabelFont: String by map
    override var tickLabelFill: Color by map
    override var tickLabelGap: Number by map
    override var tickMarkVisible: Boolean by map
    override var tickLabelsVisible: Boolean by map
}

@PublishedApi
internal class _CategoryAxisStyleBuilder(
    prettyPrint: Boolean
) : _AxisStyleBuilder(prettyPrint), CategoryAxisStyleBuilder {
    override var startMargin: Number by map
    override var endMargin: Number by map
    override var gapStartAndEnd: Boolean by map
}

open class _ChartStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), ChartStyleBuilder {
    override var legendSide: Side by map
    override var legendVisible: Boolean by map
    override var titleSide: Side by map
}

@PublishedApi
internal class _LineChartStyleBuilder(
    prettyPrint: Boolean
) : _XYChartStyleBuilder(prettyPrint), LineChartStyleBuilder {
    override var createSymbols: Boolean by map
}

@PublishedApi
internal class _NumberAxisStyleBuilder(
    prettyPrint: Boolean
) : _ValueAxisStyleBuilder(prettyPrint), NumberAxisStyleBuilder {
    override var tickUnit: Number by map
}

@PublishedApi
internal class _PieChartStyleBuilder(
    prettyPrint: Boolean
) : _ChartStyleBuilder(prettyPrint), PieChartStyleBuilder {
    override var clockwise: Boolean by map
    override var pieLabelVisible: Boolean by map
    override var labelLineLength: Number by map
    override var startAngle: Number by map
}

open class _ValueAxisStyleBuilder(
    prettyPrint: Boolean
) : _AxisStyleBuilder(prettyPrint), ValueAxisStyleBuilder {
    override var minorTickLength: Number by map
    override var minorTickCount: Number by map
    override var minorTickVisible: Boolean by map
}

open class _XYChartStyleBuilder(
    prettyPrint: Boolean
) : _ChartStyleBuilder(prettyPrint), XYChartStyleBuilder {
    override var alternativeColumnFillVisible: Boolean by map
    override var alternativeRowFillVisible: Boolean by map
    override var horizontalGridLinesVisible: Boolean by map
    override var horizontalZeroLineVisible: Boolean by map
    override var verticalGridLinesVisible: Boolean by map
    override var verticalZeroLineVisible: Boolean by map
}