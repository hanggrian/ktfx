@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

open class _SplitMenuButton : SplitMenuButton(), MenuItemInvokable {

    override fun <R : MenuItem> R.invoke(): R = also { items += it }

    /** Creates a [MenuItem] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutMarker MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [SplitMenuButton]. */
fun splitMenuButton(
    init: ((@LayoutMarker _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = _SplitMenuButton().also { init?.invoke(it) }

/** Creates a [SplitMenuButton] and add it to this manager. */
inline fun NodeInvokable.splitMenuButton(
    noinline init: ((@LayoutMarker _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = ktfx.layouts.splitMenuButton(init)()