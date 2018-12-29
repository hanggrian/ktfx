@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem

open class _MenuButton(text: String?, graphic: Node?) : MenuButton(text, graphic), MenuItemInvokable {

    override fun <R : MenuItem> R.invoke(): R = also { items + it }

    /** Creates a [MenuItem] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutMarker MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [MenuButton]. */
fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutMarker _MenuButton).() -> Unit)? = null
): MenuButton = _MenuButton(text, graphic).also { init?.invoke(it) }

/** Creates a [MenuButton] and add it to this manager. */
inline fun NodeInvokable.menuButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutMarker _MenuButton).() -> Unit)? = null
): MenuButton = ktfx.layouts.menuButton(text, graphic, init)()