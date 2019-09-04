@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane

open class _TitledPane(title: String?) : TitledPane(title, null), NodeManager {

    override fun <T : Node> T.add(): T = also { content = it }
}

/** Creates a [TitledPane]. */
fun titledPane(
    title: String? = null
): TitledPane = _TitledPane(title)

/** Creates a [TitledPane] with initialization block. */
inline fun titledPane(
    title: String? = null,
    init: (@LayoutDslMarker _TitledPane).() -> Unit
): TitledPane = (titledPane(title) as _TitledPane).apply(init)

/** Creates and add [TitledPane] to this manager. */
fun NodeManager.titledPane(
    title: String? = null
): TitledPane = ktfx.layouts.titledPane(title).add()

/** Creates and add [TitledPane] with initialization block to this manager. */
inline fun NodeManager.titledPane(
    title: String? = null,
    init: (@LayoutDslMarker _TitledPane).() -> Unit
): TitledPane = ktfx.layouts.titledPane(title, init).add()

/** Creates and add [TitledPane] to this manager. */
fun TitledPaneManager.titledPane(
    title: String? = null
): TitledPane = ktfx.layouts.titledPane(title).add()

/** Creates and add [TitledPane] with initialization block to this manager. */
inline fun TitledPaneManager.titledPane(
    title: String? = null,
    init: (@LayoutDslMarker _TitledPane).() -> Unit
): TitledPane = ktfx.layouts.titledPane(title, init).add()
