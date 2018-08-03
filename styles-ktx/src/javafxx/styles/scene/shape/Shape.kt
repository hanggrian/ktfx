@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.scene.paint.Color
import javafx.scene.shape.StrokeLineCap
import javafx.scene.shape.StrokeLineJoin
import javafx.scene.shape.StrokeType
import javafxx.styles.internal.NotImplemented
import javafxx.styles.internal._ShapeStyleBuilder

interface ShapeStyleBuilder {

    var fill: Color

    var smooth: Boolean

    var stroke: Color

    var strokeType: StrokeType

    @NotImplemented
    var strokeDashArray: String

    var strokeDashOffset: Number

    var strokeLineCap: StrokeLineCap

    var strokeLineJoin: StrokeLineJoin

    var strokeMiterLimit: Number

    var strokeWidth: Number
}

inline fun shapeStyle(
    prettyPrint: Boolean = false,
    builder: ShapeStyleBuilder.() -> Unit
): String = _ShapeStyleBuilder(prettyPrint).apply(builder).toString()