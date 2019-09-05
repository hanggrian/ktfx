@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PropertySheet

/** Add a [PropertySheet] to this manager. */
fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null
): PropertySheet = PropertySheet(items).add()

/** Add a [PropertySheet] with initialization block to this manager. */
inline fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet = propertySheet(items).apply(init)
