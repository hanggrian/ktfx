@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXComboBox
import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeInvokable

/** Creates a [JFXComboBox]. */
fun <T> jfxComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutMarker JFXComboBox<T>).() -> Unit)? = null
): JFXComboBox<T> = JFXComboBox<T>(items).also { init?.invoke(it) }

/** Creates a [JFXComboBox] and add it to this manager. */
inline fun <T> NodeInvokable.jfxComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutMarker JFXComboBox<T>).() -> Unit)? = null
): JFXComboBox<T> = ktfx.jfoenix.jfxComboBox(items, init)()