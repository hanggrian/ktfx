@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.PropertySheet

/** Creates a [PropertySheet]. */
fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: ((@LayoutDsl PropertySheet).() -> Unit)? = null
): PropertySheet = PropertySheet(items).also {
    init?.invoke(it)
}

/** Creates a [PropertySheet] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    noinline init: ((@LayoutDsl PropertySheet).() -> Unit)? = null
): PropertySheet = ktfx.controlsfx.propertySheet(items, init)()