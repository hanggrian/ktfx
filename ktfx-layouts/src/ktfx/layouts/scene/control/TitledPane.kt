@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane
import ktfx.LayoutDsl
import ktfx.NodeInvokable
import ktfx.TitledPaneInvokable

open class _TitledPane(title: String?) : TitledPane(title, null), NodeInvokable {

    override operator fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [TitledPane]. */
fun titledPane(
    title: String? = null,
    init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = _TitledPane(title).also { init?.invoke(it) }

/** Creates a [TitledPane] and add it to this manager. */
inline fun NodeInvokable.titledPane(
    title: String? = null,
    noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = ktfx.layouts.titledPane(title, init)()

/** Creates a [TitledPane] and add it to this manager. */
inline fun TitledPaneInvokable.titledPane(
    title: String? = null,
    noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = ktfx.layouts.titledPane(title, init)()