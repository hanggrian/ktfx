package ktfx.styles

import javafx.scene.paint.Color
import javafx.scene.shape.StrokeLineCap
import javafx.scene.shape.StrokeLineJoin
import javafx.scene.shape.StrokeType
import ktfx.styles.internal.Beta

interface ShapeStyleBuilder {

    var fill: Color

    var smooth: Boolean

    var stroke: Color

    var strokeType: StrokeType

    @Beta
    var strokeDashArray: String

    var strokeDashOffset: Number

    var strokeLineCap: StrokeLineCap

    var strokeLineJoin: StrokeLineJoin

    var strokeMiterLimit: Number

    var strokeWidth: Number
}

@Suppress("ClassName")
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

inline fun shapeStyle(
    prettyPrint: Boolean = false,
    builder: ShapeStyleBuilder.() -> Unit
): String = _ShapeStyleBuilder(prettyPrint).apply(builder).toString()