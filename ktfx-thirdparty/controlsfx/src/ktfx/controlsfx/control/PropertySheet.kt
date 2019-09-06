@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PropertySheet

/** Create a [PropertySheet] with initialization block. */
inline fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet = PropertySheet(items).apply(init)

/** Add a [PropertySheet] to this manager. */
fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null
): PropertySheet = addNode(ktfx.controlsfx.propertySheet(items) { })

/** Add a [PropertySheet] with initialization block to this manager. */
inline fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet = addNode(ktfx.controlsfx.propertySheet(items, init))
