@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import ktfx.styles.internal._TitledPaneStyleBuilder

interface TitledPaneStyleBuilder {

    var animated: Boolean

    var collapsible: Boolean
}

inline fun titledPaneStyle(
    prettyPrint: Boolean = false,
    builder: TitledPaneStyleBuilder .() -> Unit
): String = _TitledPaneStyleBuilder(prettyPrint).apply(builder).toString()