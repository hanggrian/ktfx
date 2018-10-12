@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.GridView

/** Creates a [GridView]. */
fun <T> gridView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = GridView(items).also { init?.invoke(it) }

/** Creates a [GridView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.gridView(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = ktfx.controlsfx.gridView(items, init)()