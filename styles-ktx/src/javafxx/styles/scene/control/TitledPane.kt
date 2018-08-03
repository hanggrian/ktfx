@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafxx.styles.internal._TitledPaneStyleBuilder

interface TitledPaneStyleBuilder {

    var animated: Boolean

    var collapsible: Boolean
}

inline fun titledPaneStyle(
    prettyPrint: Boolean = false,
    builder: TitledPaneStyleBuilder .() -> Unit
): String = _TitledPaneStyleBuilder(prettyPrint).apply(builder).toString()