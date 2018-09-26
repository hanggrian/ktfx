@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.VPos

@PublishedApi
internal class _SeparatorStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), SeparatorStyleBuilder {
    override var orientation: Orientation by map
    override var halignment: HPos by map
    override var valignment: VPos by map
}

interface SeparatorStyleBuilder {

    var orientation: Orientation

    var halignment: HPos

    var valignment: VPos
}

inline fun separatorStyle(
    prettyPrint: Boolean = false,
    builder: SeparatorStyleBuilder .() -> Unit
): String = _SeparatorStyleBuilder(prettyPrint).apply(builder).toString()