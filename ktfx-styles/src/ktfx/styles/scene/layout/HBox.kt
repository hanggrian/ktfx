@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos
import ktfx.styles.internal._HBoxStyleBuilder

interface HBoxStyleBuilder : RegionStyleBuilder {

    var spacing: Number

    var alignment: Pos

    var fillHeight: Boolean
}

inline fun hboxStyle(
    prettyPrint: Boolean = false,
    builder: HBoxStyleBuilder.() -> Unit
): String = _HBoxStyleBuilder(prettyPrint).apply(builder).toString()