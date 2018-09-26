@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.VPos
import javafx.scene.text.FontPosture
import javafx.scene.text.FontSmoothingType
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import ktfx.styles.internal.NotImplemented
import ktfx.styles.internal._TextStyleBuilder

interface TextStyleBuilder {

    /** Shorthand property for font-size, font-family, font-weight and font-style. */
    @NotImplemented
    var font: String

    var fontFamily: String

    var fontSize: Number

    var fontStyle: FontPosture

    var fontWeight: FontWeight

    var fontSmoothingType: FontSmoothingType

    var strikethrough: Boolean

    var textAlignment: TextAlignment

    var textOrigin: VPos

    var underline: Boolean
}

inline fun textStyle(
    prettyPrint: Boolean = false,
    builder: TextStyleBuilder.() -> Unit
): String = _TextStyleBuilder(prettyPrint).apply(builder).toString()