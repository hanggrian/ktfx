@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.scene.control.CheckBoxTreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.CheckTreeView

/** Create a [CheckTreeView] with initialization block. */
inline fun <T> checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    init: (@LayoutDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> = CheckTreeView(root).apply(init)

/** Add a [CheckTreeView] to this manager. */
fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null
): CheckTreeView<T> = addNode(CheckTreeView(root))

/** Add a [CheckTreeView] with initialization block to this manager. */
inline fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    init: (@LayoutDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> = addNode(CheckTreeView(root), init)
