@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafxx.styles.internal._TabPaneStyleBuilder

interface TabPaneStyleBuilder {

    var tabMinWidth: Int

    var tabMaxWidth: Int

    var tabMinHeight: Int

    var tabMaxHeight: Int
}

inline fun tabPaneStyle(
    prettyPrint: Boolean = false,
    builder: TabPaneStyleBuilder .() -> Unit
): String = _TabPaneStyleBuilder(prettyPrint).apply(builder).toString()