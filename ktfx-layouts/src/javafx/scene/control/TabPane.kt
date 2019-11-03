@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

open class KtfxTabPane : TabPane(), TabManager {

    final override fun <T : Tab> addTab(tab: T): T =
        tab.also { tabs += it }

    /** Call [TabManager.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker KtfxTab).() -> Unit
    ): Tab = tab(this, graphic, init)
}

/** Create a [TabPane] with initialization block. */
inline fun tabPane(
    init: (@LayoutDslMarker KtfxTabPane).() -> Unit
): TabPane = KtfxTabPane().apply(init)

/** Add a [TabPane] to this manager. */
fun NodeManager.tabPane(): TabPane =
    addNode(KtfxTabPane())

/** Add a [TabPane] with initialization block to this manager. */
inline fun NodeManager.tabPane(
    init: (@LayoutDslMarker KtfxTabPane).() -> Unit
): TabPane = addNode(KtfxTabPane(), init)
