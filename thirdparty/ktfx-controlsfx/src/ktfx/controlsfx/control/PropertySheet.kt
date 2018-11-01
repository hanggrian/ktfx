@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.NodeManager
import ktfx.LayoutDsl
import org.controlsfx.control.PropertySheet

/** Creates a [PropertySheet]. */
fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: ((@LayoutDsl PropertySheet).() -> Unit)? = null
): PropertySheet = PropertySheet(items).also { init?.invoke(it) }

/** Creates a [PropertySheet] and add it to this manager. */
inline fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    noinline init: ((@LayoutDsl PropertySheet).() -> Unit)? = null
): PropertySheet = ktfx.controlsfx.propertySheet(items, init)()