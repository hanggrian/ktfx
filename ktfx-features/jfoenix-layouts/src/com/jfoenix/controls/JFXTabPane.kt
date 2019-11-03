@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTabPane
import javafx.scene.Node
import javafx.scene.control.Tab
import ktfx.layouts.KtfxTab
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.TabManager
import ktfx.layouts.addNode
import ktfx.layouts.tab

open class KtfxJFXTabPane : JFXTabPane(), TabManager {

    final override fun <T : Tab> addTab(tab: T): T =
        tab.also { tabs += it }

    /** Call [TabManager.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker KtfxTab).() -> Unit
    ): Tab = tab(this, graphic, init)
}

/** Create a [JFXTabPane] with initialization block. */
inline fun jfxTabPane(
    init: (@LayoutDslMarker KtfxJFXTabPane).() -> Unit
): JFXTabPane = KtfxJFXTabPane().apply(init)

/** Add a [JFXTabPane] to this manager. */
fun NodeManager.jfxTabPane(): JFXTabPane =
    addNode(KtfxJFXTabPane())

/** Add a [JFXTabPane] with initialization block to this manager. */
inline fun NodeManager.jfxTabPane(
    init: (@LayoutDslMarker KtfxJFXTabPane).() -> Unit
): JFXTabPane = addNode(KtfxJFXTabPane(), init)
