@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Side
import javafx.scene.paint.Color
import ktfx.styles.internal.NotImplemented
import ktfx.styles.internal._AxisStyleBuilder

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