@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.PrefixSelectionComboBox

/** Creates a [PrefixSelectionComboBox]. */
fun <T> prefixSelectionComboBox(
    init: ((@LayoutDsl PrefixSelectionComboBox<T>).() -> Unit)? = null
): PrefixSelectionComboBox<T> = PrefixSelectionComboBox<T>().also {
    init?.invoke(it)
}

/** Creates a [PrefixSelectionComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.prefixSelectionComboBox(
    noinline init: ((@LayoutDsl PrefixSelectionComboBox<T>).() -> Unit)? = null
): PrefixSelectionComboBox<T> = ktfx.controlsfx.prefixSelectionComboBox(init)()

/** Create a styled [PrefixSelectionComboBox]. */
fun <T> styledPrefixSelectionComboBox(
    styleClass: String,
    init: ((@LayoutDsl PrefixSelectionComboBox<T>).() -> Unit)? = null
): PrefixSelectionComboBox<T> = PrefixSelectionComboBox<T>().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [PrefixSelectionComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledPrefixSelectionComboBox(
    styleClass: String,
    noinline init: ((@LayoutDsl PrefixSelectionComboBox<T>).() -> Unit)? = null
): PrefixSelectionComboBox<T> = ktfx.controlsfx.styledPrefixSelectionComboBox(styleClass, init)()