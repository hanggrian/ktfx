@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos

@PublishedApi
internal class _FlowPaneStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), FlowPaneStyleBuilder {
    override var hgap: Number by map
    override var vgap: Number by map
    override var alignment: Pos by map
    override var columnHalignment: HPos by map
    override var rowValignment: VPos by map
    override var orientation: Orientation by map
}

interface FlowPaneStyleBuilder {

    var hgap: Number

    var vgap: Number

    var alignment: Pos

    var columnHalignment: HPos

    var rowValignment: VPos

    var orientation: Orientation
}

inline fun flowPaneStyle(
    prettyPrint: Boolean = false,
    builder: FlowPaneStyleBuilder.() -> Unit
): String = _FlowPaneStyleBuilder(prettyPrint).apply(builder).toString()