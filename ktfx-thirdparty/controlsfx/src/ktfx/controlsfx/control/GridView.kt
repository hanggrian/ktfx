@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeInvokable
import org.controlsfx.control.GridView

/** Creates a [GridView]. */
fun <T> gridView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutMarker GridView<T>).() -> Unit)? = null
): GridView<T> = GridView(items).also { init?.invoke(it) }

/** Creates a [GridView] and add it to this manager. */
inline fun <T> NodeInvokable.gridView(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutMarker GridView<T>).() -> Unit)? = null
): GridView<T> = ktfx.controlsfx.gridView(items, init)()