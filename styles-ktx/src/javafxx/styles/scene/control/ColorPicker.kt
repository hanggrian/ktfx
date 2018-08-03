@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafxx.styles.internal._ColorPickerStyleBuilder

interface ColorPickerStyleBuilder {

    var colorLabelVisible: Boolean
}

inline fun colorPickerStyle(
    prettyPrint: Boolean = false,
    builder: ColorPickerStyleBuilder .() -> Unit
): String = _ColorPickerStyleBuilder(prettyPrint).apply(builder).toString()