@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTabPane
import javafx.scene.Node
import javafx.scene.control.Tab
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeInvokable
import ktfx.layouts.TabInvokable
import ktfx.layouts._Tab
import ktfx.layouts.tab

open class _JFXTabPane : JFXTabPane(), TabInvokable {

    override fun <R : Tab> R.invoke(): R = also { tabs += it }

    /** Creates a [Tab] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutMarker _Tab).() -> Unit)? = null
    ): Tab = tab(this, graphic, init)
}

/** Creates a [JFXTabPane]. */
fun jfxTabPane(
    init: ((@LayoutMarker _JFXTabPane).() -> Unit)? = null
): JFXTabPane = _JFXTabPane().also { init?.invoke(it) }

/** Creates a [JFXTabPane] and add it to this manager. */
inline fun NodeInvokable.jfxTabPane(
    noinline init: ((@LayoutMarker _JFXTabPane).() -> Unit)? = null
): JFXTabPane = ktfx.jfoenix.jfxTabPane(init)()