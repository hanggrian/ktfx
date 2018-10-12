@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ChoiceBox
import ktfx.collections.mutableObservableListOf

/** Creates a [ChoiceBox]. */
fun <T> choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).also { init?.invoke(it) }

/** Creates a [ChoiceBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init)()