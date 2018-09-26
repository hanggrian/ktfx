@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos

@PublishedApi
internal class _HBoxStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), HBoxStyleBuilder {
    override var spacing: Number by map
    override var alignment: Pos by map
    override var fillHeight: Boolean by map
}

interface HBoxStyleBuilder : RegionStyleBuilder {

    var spacing: Number

    var alignment: Pos

    var fillHeight: Boolean
}

inline fun hboxStyle(
    prettyPrint: Boolean = false,
    builder: HBoxStyleBuilder.() -> Unit
): String = _HBoxStyleBuilder(prettyPrint).apply(builder).toString()