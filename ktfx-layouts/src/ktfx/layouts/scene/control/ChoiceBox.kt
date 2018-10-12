@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ChoiceBox

/** Creates a [ChoiceBox]. */
fun <T> choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).also { init?.invoke(it) }

/** Creates a [ChoiceBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init)()