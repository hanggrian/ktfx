@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.CheckComboBox

/** Creates a [CheckComboBox]. */
fun <T> checkComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = CheckComboBox(items).also {
    init?.invoke(it)
}

/** Creates a [CheckComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.checkComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = ktfx.controlsfx.checkComboBox(items, init)()