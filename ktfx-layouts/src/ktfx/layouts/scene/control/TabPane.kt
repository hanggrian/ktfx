@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

open class _TabPane : TabPane(), TabInvokable {

    override fun <R : Tab> R.invoke(): R = also { tabs += it }

    /** Creates a [Tab] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Tab).() -> Unit)? = null
    ): Tab = tab(this, graphic, init)
}

/** Creates a [TabPane]. */
fun tabPane(
    init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = _TabPane().also { init?.invoke(it) }

/** Creates a [TabPane] and add it to this manager. */
inline fun NodeInvokable.tabPane(
    noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = ktfx.layouts.tabPane(init)()