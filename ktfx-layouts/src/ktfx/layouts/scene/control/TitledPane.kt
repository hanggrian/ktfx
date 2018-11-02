@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane
import ktfx.LayoutDsl
import ktfx.NodeInvokable

open class _TitledPane(title: String?, content: Node?) : TitledPane(title, content), NodeInvokable {

    override operator fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [TitledPane]. */
fun titledPane(
    text: String? = null,
    content: Node? = null,
    init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = _TitledPane(text, content).also { init?.invoke(it) }

/** Creates a [TitledPane] and add it to this manager. */
inline fun NodeInvokable.titledPane(
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = ktfx.layouts.titledPane(text, content, init)()