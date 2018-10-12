@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXComboBox
import javafx.collections.ObservableList
import javafx.scene.Node
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXComboBox]. */
fun <T> jfxComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl JFXComboBox<T>).() -> Unit)? = null
): JFXComboBox<T> = JFXComboBox<T>(items).also { init?.invoke(it) }

/** Creates a [JFXComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl JFXComboBox<T>).() -> Unit)? = null
): JFXComboBox<T> = ktfx.jfoenix.jfxComboBox(items, init)()