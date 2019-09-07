@file:JvmMultifileClass
@file:JvmName("RegionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.geometry.Insets
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Paint

/** Set multiple strokes to region's border. */
fun Region.updateBorder(vararg strokes: BorderStroke) {
    border = Border(*strokes)
}

/** Update region's border stroke with native [Insets]. */
inline fun Region.updateBorder(
    stroke: Paint? = null,
    style: BorderStrokeStyle? = null,
    radii: CornerRadii? = null,
    widths: BorderWidths? = null,
    padding: Insets? = null
): Unit = updateBorder(BorderStroke(stroke, style, radii, widths, padding))

/** Update region's border stroke with parameterized padding. */
inline fun Region.updateBorder(
    stroke: Paint? = null,
    style: BorderStrokeStyle? = null,
    radii: CornerRadii? = null,
    widths: BorderWidths? = null,
    topPadding: Double = 0.0,
    rightPadding: Double = 0.0,
    bottomPadding: Double = 0.0,
    leftPadding: Double = 0.0
): Unit = updateBorder(
    BorderStroke(
        stroke,
        style,
        radii,
        widths,
        Insets(topPadding, rightPadding, bottomPadding, leftPadding)
    )
)

/** Update region's border stroke with native [Insets]. */
inline fun Region.updateBorder(
    topStroke: Paint? = null,
    rightStroke: Paint? = null,
    bottomStroke: Paint? = null,
    leftStroke: Paint? = null,
    topStyle: BorderStrokeStyle? = null,
    rightStyle: BorderStrokeStyle? = null,
    bottomStyle: BorderStrokeStyle? = null,
    leftStyle: BorderStrokeStyle? = null,
    radii: CornerRadii? = null,
    widths: BorderWidths? = null,
    padding: Insets? = null
): Unit = updateBorder(
    BorderStroke(
        topStroke,
        rightStroke,
        bottomStroke,
        leftStroke,
        topStyle,
        rightStyle,
        bottomStyle,
        leftStyle,
        radii,
        widths,
        padding
    )
)

/** Update region's border stroke with parameterized padding. */
inline fun Region.updateBorder(
    topStroke: Paint? = null,
    rightStroke: Paint? = null,
    bottomStroke: Paint? = null,
    leftStroke: Paint? = null,
    topStyle: BorderStrokeStyle? = null,
    rightStyle: BorderStrokeStyle? = null,
    bottomStyle: BorderStrokeStyle? = null,
    leftStyle: BorderStrokeStyle? = null,
    radii: CornerRadii? = null,
    widths: BorderWidths? = null,
    topPadding: Double = 0.0,
    rightPadding: Double = 0.0,
    bottomPadding: Double = 0.0,
    leftPadding: Double = 0.0
): Unit = updateBorder(
    BorderStroke(
        topStroke,
        rightStroke,
        bottomStroke,
        leftStroke,
        topStyle,
        rightStyle,
        bottomStyle,
        leftStyle,
        radii,
        widths,
        Insets(topPadding, rightPadding, bottomPadding, leftPadding)
    )
)
