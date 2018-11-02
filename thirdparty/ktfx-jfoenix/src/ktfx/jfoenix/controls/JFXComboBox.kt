@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXComboBox
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [JFXComboBox]. */
fun <T> jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl JFXComboBox<T>).() -> Unit)? = null
): JFXComboBox<T> = JFXComboBox<T>(items).also { init?.invoke(it) }

/** Creates a [JFXComboBox] and add it to this manager. */
inline fun <T> NodeInvokable.jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl JFXComboBox<T>).() -> Unit)? = null
): JFXComboBox<T> = ktfx.jfoenix.jfxComboBox(items, init)()