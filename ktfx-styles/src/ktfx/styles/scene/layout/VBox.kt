@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos

@PublishedApi
internal class _VBoxStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), VBoxStyleBuilder {
    override var spacing: Number by map
    override var alignment: Pos by map
    override var fillWidth: Boolean by map
}

interface VBoxStyleBuilder {

    var spacing: Number

    var alignment: Pos

    var fillWidth: Boolean
}

inline fun vboxStyle(
    prettyPrint: Boolean = false,
    builder: VBoxStyleBuilder.() -> Unit
): String = _VBoxStyleBuilder(prettyPrint).apply(builder).toString()