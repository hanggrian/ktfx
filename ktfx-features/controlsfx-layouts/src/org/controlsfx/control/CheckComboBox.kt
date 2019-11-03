@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.CheckComboBox

/** Create a [CheckComboBox] with initialization block. */
inline fun <T> checkComboBox(
    items: ObservableList<T>? = null,
    init: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> = CheckComboBox(items).apply(init)

/** Add a [CheckComboBox] to this manager. */
fun <T> NodeManager.checkComboBox(
    items: ObservableList<T>? = null
): CheckComboBox<T> = addNode(CheckComboBox(items))

/** Add a [CheckComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.checkComboBox(
    items: ObservableList<T>? = null,
    init: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> = addNode(CheckComboBox(items), init)
