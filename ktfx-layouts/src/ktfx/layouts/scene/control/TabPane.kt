@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

open class _TabPane(
    vararg tabs: Tab
) : TabPane(*tabs), LayoutManager<Tab> {

    override val childs: MutableCollection<Tab> get() = tabs

    /** Creates a [Tab] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Tab).() -> Unit)? = null
    ): Tab = tab(this, graphic, init)

    /** Creates a styled [Tab] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        styleClass: String,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl _Tab).() -> Unit)? = null
    ): Tab = styledTab(styleClass, this, graphic, init)
}

/** Creates a [TabPane]. */
fun tabPane(
    vararg tabs: Tab,
    init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = _TabPane(*tabs).also {
    init?.invoke(it)
}

/** Creates a [TabPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.tabPane(
    vararg tabs: Tab,
    noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = ktfx.layouts.tabPane(*tabs, init = init)()

/** Create a styled [TabPane]. */
fun styledTabPane(
    styleClass: String,
    vararg tabs: Tab,
    init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = _TabPane(*tabs).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TabPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledTabPane(
    styleClass: String,
    vararg tabs: Tab,
    noinline init: ((@LayoutDsl _TabPane).() -> Unit)? = null
): TabPane = ktfx.layouts.styledTabPane(styleClass, *tabs, init = init)()