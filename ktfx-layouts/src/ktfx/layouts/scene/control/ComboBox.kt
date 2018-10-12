@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ComboBox
import ktfx.collections.mutableObservableListOf

/** Creates a [ComboBox]. */
fun <T> comboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).also { init?.invoke(it) }

/** Creates a [ComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.comboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ktfx.layouts.comboBox(items, init)()