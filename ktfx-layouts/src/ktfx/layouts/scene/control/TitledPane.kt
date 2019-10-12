@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane

open class KtfxTitledPane(title: String?) : TitledPane(title, null), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }
}

/** Create a [TitledPane] with initialization block. */
inline fun titledPane(
    title: String? = null,
    init: (@LayoutDslMarker KtfxTitledPane).() -> Unit
): TitledPane = KtfxTitledPane(title).apply(init)

/** Add a [TitledPane] to this manager. */
fun NodeManager.titledPane(
    title: String? = null
): TitledPane = addNode(ktfx.layouts.titledPane(title) { })

/** Add a [TitledPane] with initialization block to this manager. */
inline fun NodeManager.titledPane(
    title: String? = null,
    init: (@LayoutDslMarker KtfxTitledPane).() -> Unit
): TitledPane = addNode(ktfx.layouts.titledPane(title, init))

/** Add a [TitledPane] to this manager. */
fun TitledPaneManager.titledPane(
    title: String? = null
): TitledPane = addPane(ktfx.layouts.titledPane(title) { })

/** Add a [TitledPane] with initialization block to this manager. */
inline fun TitledPaneManager.titledPane(
    title: String? = null,
    init: (@LayoutDslMarker KtfxTitledPane).() -> Unit
): TitledPane = addPane(ktfx.layouts.titledPane(title, init))
