@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _NumberAxisStyleBuilder(
    prettyPrint: Boolean
) : _ValueAxisStyleBuilder(prettyPrint), NumberAxisStyleBuilder {
    override var tickUnit: Number by map
}

interface NumberAxisStyleBuilder {

    /** The value between each major tick mark in data units. */
    var tickUnit: Number
}

inline fun numberAxisStyle(
    prettyPrint: Boolean = false,
    builder: NumberAxisStyleBuilder.() -> Unit
): String = _NumberAxisStyleBuilder(prettyPrint).apply(builder).toString()