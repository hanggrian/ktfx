@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.control.CheckBoxTreeItem
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutDsl
import org.controlsfx.control.CheckTreeView

/** Creates a [CheckTreeView]. */
fun <T> checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    init: ((@LayoutDsl CheckTreeView<T>).() -> Unit)? = null
): CheckTreeView<T> = CheckTreeView<T>(root).also { init?.invoke(it) }

/** Creates a [CheckTreeView] and add it to this manager. */
inline fun <T> NodeInvokable.checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    noinline init: ((@LayoutDsl CheckTreeView<T>).() -> Unit)? = null
): CheckTreeView<T> = ktfx.controlsfx.checkTreeView(root, init)()