@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafxx.styles.internal._RectangleStyleBuilder

interface RectangleStyleBuilder {

    var arcHeight: Number

    var arcWidth: Number
}

inline fun rectangleStyle(
    prettyPrint: Boolean = false,
    builder: RectangleStyleBuilder.() -> Unit
): String = _RectangleStyleBuilder(prettyPrint).apply(builder).toString()