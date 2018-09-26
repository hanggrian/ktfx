@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

open class _ValueAxisStyleBuilder(
    prettyPrint: Boolean
) : _AxisStyleBuilder(prettyPrint), ValueAxisStyleBuilder {
    override var minorTickLength: Number by map
    override var minorTickCount: Number by map
    override var minorTickVisible: Boolean by map
}

interface ValueAxisStyleBuilder {

    var minorTickLength: Number

    var minorTickCount: Number

    var minorTickVisible: Boolean
}

inline fun valueAxisStyle(
    prettyPrint: Boolean = false,
    builder: ValueAxisStyleBuilder.() -> Unit
): String = _ValueAxisStyleBuilder(prettyPrint).apply(builder).toString()