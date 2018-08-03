@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos
import javafxx.styles.internal._HBoxStyleBuilder

interface HBoxStyleBuilder : RegionStyleBuilder {

    var spacing: Number

    var alignment: Pos

    var fillHeight: Boolean
}

inline fun hboxStyle(
    prettyPrint: Boolean = false,
    builder: HBoxStyleBuilder.() -> Unit
): String = _HBoxStyleBuilder(prettyPrint).apply(builder).toString()