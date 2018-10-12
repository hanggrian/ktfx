@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.BreadCrumbBar

/** Creates a [BreadCrumbBar]. */
fun <T> breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    init: ((@LayoutDsl BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = BreadCrumbBar<T>(selectedCrumb).also { init?.invoke(it) }

/** Creates a [BreadCrumbBar] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = ktfx.controlsfx.breadCrumbBar(selectedCrumb, init)()