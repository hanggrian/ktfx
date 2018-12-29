@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeInvokable
import org.controlsfx.control.CheckComboBox

/** Creates a [CheckComboBox]. */
fun <T> checkComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutMarker CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = CheckComboBox(items).also { init?.invoke(it) }

/** Creates a [CheckComboBox] and add it to this manager. */
inline fun <T> NodeInvokable.checkComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutMarker CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = ktfx.controlsfx.checkComboBox(items, init)()