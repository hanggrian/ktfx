@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.TitledPane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _TitledPane(title: String?, content: Node?) : TitledPane(title, content), NodeManager {

    override operator fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [TitledPane]. */
fun titledPane(
    text: String? = null,
    content: Node? = null,
    init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = _TitledPane(text, content).also { init?.invoke(it) }

/** Creates a [TitledPane] and add it to this manager. */
inline fun NodeManager.titledPane(
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = ktfx.layouts.titledPane(text, content, init)()