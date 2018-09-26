@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.scene.paint.Color

open class _ProgressIndicatorStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ProgressIndicatorStyleBuilder {
    override var progressColor: Color by map
}

interface ProgressIndicatorStyleBuilder {

    var progressColor: Color
}

inline fun progressIndicatorStyle(
    prettyPrint: Boolean = false,
    builder: ProgressIndicatorStyleBuilder .() -> Unit
): String = _ProgressIndicatorStyleBuilder(prettyPrint).apply(builder).toString()