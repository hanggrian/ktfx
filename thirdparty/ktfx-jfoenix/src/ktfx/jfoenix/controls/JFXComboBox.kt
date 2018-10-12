@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXComboBox
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXComboBox]. */
fun <T> jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl JFXComboBox<T>).() -> Unit)? = null
): JFXComboBox<T> = JFXComboBox<T>(items).also { init?.invoke(it) }

/** Creates a [JFXComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl JFXComboBox<T>).() -> Unit)? = null
): JFXComboBox<T> = ktfx.jfoenix.jfxComboBox(items, init)()