@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos

@PublishedApi
internal class _GridPaneStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), GridPaneStyleBuilder {
    override var hgap: Number by map
    override var vgap: Number by map
    override var alignment: Pos by map
    override var gridLinesVisible: Boolean by map
}

interface GridPaneStyleBuilder {

    var hgap: Number

    var vgap: Number

    var alignment: Pos

    var gridLinesVisible: Boolean
}

inline fun gridPaneStyle(
    prettyPrint: Boolean = false,
    builder: GridPaneStyleBuilder.() -> Unit
): String = _GridPaneStyleBuilder(prettyPrint).apply(builder).toString()