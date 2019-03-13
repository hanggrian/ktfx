@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import ktfx.collections.observableListOf

/** Creates a [ComboBox]. */
fun <T> comboBox(
    items: ObservableList<T> = observableListOf(),
    init: ((@LayoutDslMarker ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).also { init?.invoke(it) }

/** Creates a [ComboBox] and add it to this manager. */
inline fun <T> NodeManager.comboBox(
    items: ObservableList<T> = observableListOf(),
    noinline init: ((@LayoutDslMarker ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ktfx.layouts.comboBox(items, init).add()