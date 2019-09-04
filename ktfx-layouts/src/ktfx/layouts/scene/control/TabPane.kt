@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

open class _TabPane : TabPane(), TabManager {

    override fun <R : Tab> R.add(): R = also { tabs += it }

    /** Call [TabManager.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker _Tab).() -> Unit
    ): Tab = tab(this, graphic, init)
}

/** Add a [TabPane] to this manager. */
fun NodeManager.tabPane(): TabPane =
    TabPane().add()

/** Add a [TabPane] with initialization block to this manager. */
inline fun NodeManager.tabPane(
    init: (@LayoutDslMarker _TabPane).() -> Unit
): TabPane = (tabPane() as _TabPane).apply(init)
