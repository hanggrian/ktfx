@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.scene.paint.Color
import ktfx.styles.internal._ProgressIndicatorStyleBuilder

interface ProgressIndicatorStyleBuilder {

    var progressColor: Color
}

inline fun progressIndicatorStyle(
    prettyPrint: Boolean = false,
    builder: ProgressIndicatorStyleBuilder .() -> Unit
): String = _ProgressIndicatorStyleBuilder(prettyPrint).apply(builder).toString()