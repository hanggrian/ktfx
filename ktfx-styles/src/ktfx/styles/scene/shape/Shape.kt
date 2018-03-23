package ktfx.styles

import javafx.scene.paint.Color
import javafx.scene.shape.StrokeLineCap
import javafx.scene.shape.StrokeLineJoin
import javafx.scene.shape.StrokeType

open class ShapeStyleBuilder(prettyPrint: Boolean) : NodeStyleBuilder(prettyPrint) {

    var fill: Color by map

    var smooth: Boolean by map

    var stroke: Color by map

    var strokeType: StrokeType by map

    @Incubating
    var strokeDashArray: String by map

    var strokeDashOffset: Number by map

    var strokeLineCap: StrokeLineCap by map

    var strokeLineJoin: StrokeLineJoin by map

    var strokeMiterLimit: Number by map

    var strokeWidth: Number by map
}

inline fun shapeStyle(
    prettyPrint: Boolean = false,
    builder: ShapeStyleBuilder.() -> Unit
): String = ShapeStyleBuilder(prettyPrint).apply(builder).toString()