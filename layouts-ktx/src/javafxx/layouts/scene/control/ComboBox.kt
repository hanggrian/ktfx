@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ComboBox
import javafxx.collections.mutableObservableListOf

/** Creates a [ComboBox]. */
fun <T> comboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).also {
    init?.invoke(it)
}

/** Creates a [ComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.comboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = javafxx.layouts.comboBox(items, init)()

/** Create a styled [ComboBox]. */
fun <T> styledComboBox(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledComboBox(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = javafxx.layouts.styledComboBox(styleClass, items, init)()