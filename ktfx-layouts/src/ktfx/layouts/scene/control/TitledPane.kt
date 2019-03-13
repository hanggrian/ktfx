@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane

open class _TitledPane(title: String?) : TitledPane(title, null), NodeManager {

    override fun <T : Node> T.add(): T = also { content = it }
}

/** Creates a [TitledPane]. */
fun titledPane(
    title: String? = null,
    init: ((@LayoutDslMarker _TitledPane).() -> Unit)? = null
): TitledPane = _TitledPane(title).also { init?.invoke(it) }

/** Creates a [TitledPane] and add it to this manager. */
inline fun NodeManager.titledPane(
    title: String? = null,
    noinline init: ((@LayoutDslMarker _TitledPane).() -> Unit)? = null
): TitledPane = ktfx.layouts.titledPane(title, init).add()

/** Creates a [TitledPane] and add it to this manager. */
inline fun TitledPaneManager.titledPane(
    title: String? = null,
    noinline init: ((@LayoutDslMarker _TitledPane).() -> Unit)? = null
): TitledPane = ktfx.layouts.titledPane(title, init).add()