@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTabPane
import javafx.scene.Node
import javafx.scene.control.Tab
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.TabManager
import ktfx.layouts._Tab
import ktfx.layouts.tab

open class _JFXTabPane : JFXTabPane(), TabManager {

    override fun <T : Tab> addTab(tab: T): T = tab.also { tabs += it }

    /** Call [TabManager.tab] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker _Tab).() -> Unit
    ): Tab = tab(this, graphic, init)
}

/** Create a [JFXTabPane] with initialization block. */
inline fun jfxTabPane(
    init: (@LayoutDslMarker _JFXTabPane).() -> Unit
): JFXTabPane = _JFXTabPane().apply(init)

/** Add a [JFXTabPane] to this manager. */
fun NodeManager.jfxTabPane(): JFXTabPane =
    addNode(ktfx.jfoenix.jfxTabPane { })

/** Add a [JFXTabPane] with initialization block to this manager. */
inline fun NodeManager.jfxTabPane(
    init: (@LayoutDslMarker _JFXTabPane).() -> Unit
): JFXTabPane = addNode(ktfx.jfoenix.jfxTabPane(init))
