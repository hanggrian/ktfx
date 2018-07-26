@file:Suppress("ClassName")

package javafxx.styles.internal

import javafx.scene.paint.Color
import javafx.scene.shape.StrokeLineCap
import javafx.scene.shape.StrokeLineJoin
import javafx.scene.shape.StrokeType
import javafxx.styles.RectangleStyleBuilder
import javafxx.styles.ShapeStyleBuilder

@PublishedApi
internal class _RectangleStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), RectangleStyleBuilder {
    override var arcHeight: Number by map
    override var arcWidth: Number by map
}

open class _ShapeStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), ShapeStyleBuilder {
    override var fill: Color by map
    override var smooth: Boolean by map
    override var stroke: Color by map
    override var strokeType: StrokeType by map
    override var strokeDashArray: String by map
    override var strokeDashOffset: Number by map
    override var strokeLineCap: StrokeLineCap by map
    override var strokeLineJoin: StrokeLineJoin by map
    override var strokeMiterLimit: Number by map
    override var strokeWidth: Number by map
}