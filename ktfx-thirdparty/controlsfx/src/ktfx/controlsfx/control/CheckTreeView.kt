@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.scene.control.CheckBoxTreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.CheckTreeView

/** Add a [CheckTreeView] to this manager. */
fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null
): CheckTreeView<T> = CheckTreeView(root).add()

/** Add a [CheckTreeView] with initialization block to this manager. */
inline fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    init: (@LayoutDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> = checkTreeView(root).apply(init)
