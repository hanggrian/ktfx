@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.geometry.Side
import javafx.scene.paint.Color
import javafxx.styles.internal.NotImplemented
import javafxx.styles.internal._AxisStyleBuilder

interface AxisStyleBuilder {

    var side: Side

    var tickLength: Number

    @NotImplemented
    var tickLabelFont: String

    var tickLabelFill: Color

    var tickLabelGap: Number

    var tickMarkVisible: Boolean

    var tickLabelsVisible: Boolean
}

inline fun axisStyle(
    prettyPrint: Boolean = false,
    builder: AxisStyleBuilder.() -> Unit
): String = _AxisStyleBuilder(prettyPrint).apply(builder).toString()