@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import ktfx.MenuItemManager
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _MenuButton(text: String?, graphic: Node?) : MenuButton(text, graphic), MenuItemManager {

    override val collection: MutableCollection<MenuItem> get() = items

    /** Creates a [MenuItem] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [MenuButton]. */
fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl _MenuButton).() -> Unit)? = null
): MenuButton = _MenuButton(text, graphic).also { init?.invoke(it) }

/** Creates a [MenuButton] and add it to this manager. */
inline fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl _MenuButton).() -> Unit)? = null
): MenuButton = ktfx.layouts.menuButton(text, graphic, init)()