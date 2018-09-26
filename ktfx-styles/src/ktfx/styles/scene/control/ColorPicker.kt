@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _ColorPickerStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint),
    ColorPickerStyleBuilder {
    override var colorLabelVisible: Boolean by map
}

interface ColorPickerStyleBuilder {

    var colorLabelVisible: Boolean
}

inline fun colorPickerStyle(
    prettyPrint: Boolean = false,
    builder: ColorPickerStyleBuilder .() -> Unit
): String = _ColorPickerStyleBuilder(prettyPrint).apply(builder).toString()