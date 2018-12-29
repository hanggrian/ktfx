@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar

open class _MenuBar : MenuBar(), MenuInvokable {

    override fun <R : Menu> R.invoke(): R = also { menus += it }

    /** Creates a [Menu] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutMarker _Menu).() -> Unit)? = null
    ): Menu = menu(this, graphic, init)()
}

/** Creates a [MenuBar]. */
fun menuBar(
    init: ((@LayoutMarker _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar().also { init?.invoke(it) }

/** Creates a [MenuBar] and add it to this manager. */
inline fun NodeInvokable.menuBar(
    noinline init: ((@LayoutMarker _MenuBar).() -> Unit)? = null
): MenuBar = ktfx.layouts.menuBar(init)()