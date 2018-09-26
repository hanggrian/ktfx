@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

open class _ControlStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), ControlStyleBuilder {
    override var skin: String by map
}

interface ControlStyleBuilder {

    /** The class name of the Control's Skin. */
    var skin: String
}

inline fun controlStyle(
    prettyPrint: Boolean = false,
    builder: ControlStyleBuilder .() -> Unit
): String = _ControlStyleBuilder(prettyPrint).apply(builder).toString()