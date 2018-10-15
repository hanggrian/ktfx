@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.control.CheckBoxTreeItem
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.CheckTreeView

/** Creates a [CheckTreeView]. */
fun <T> checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    init: ((@LayoutDsl CheckTreeView<T>).() -> Unit)? = null
): CheckTreeView<T> = CheckTreeView<T>(root).also { init?.invoke(it) }

/** Creates a [CheckTreeView] and add it to this manager. */
inline fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    noinline init: ((@LayoutDsl CheckTreeView<T>).() -> Unit)? = null
): CheckTreeView<T> = ktfx.controlsfx.checkTreeView(root, init)()