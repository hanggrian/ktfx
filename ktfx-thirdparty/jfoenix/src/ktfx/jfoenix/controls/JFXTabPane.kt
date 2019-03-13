@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

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

    override fun <R : Tab> R.add(): R = also { tabs += it }

    /** Creates a [Tab] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDslMarker _Tab).() -> Unit)? = null
    ): Tab = tab(this, graphic, init)
}

/** Creates a [JFXTabPane]. */
fun jfxTabPane(
    init: ((@LayoutDslMarker _JFXTabPane).() -> Unit)? = null
): JFXTabPane = _JFXTabPane().also { init?.invoke(it) }

/** Creates a [JFXTabPane] and add it to this manager. */
inline fun NodeManager.jfxTabPane(
    noinline init: ((@LayoutDslMarker _JFXTabPane).() -> Unit)? = null
): JFXTabPane = ktfx.jfoenix.jfxTabPane(init).add()