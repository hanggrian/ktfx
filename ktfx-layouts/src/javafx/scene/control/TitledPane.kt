@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxTitledPane(title: String?) : TitledPane(title, null), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }
}

/** Create a [TitledPane] with initialization block. */
inline fun titledPane(
    title: String? = null,
    init: (@LayoutDslMarker KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxTitledPane(title).apply(init)
}
/** Add a [TitledPane] to this manager. */
fun NodeManager.titledPane(
    title: String? = null
): TitledPane = addNode(KtfxTitledPane(title))

/** Add a [TitledPane] with initialization block to this manager. */
inline fun NodeManager.titledPane(
    title: String? = null,
    init: (@LayoutDslMarker KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxTitledPane(title), init)
}
/** Add a [TitledPane] to this manager. */
fun TitledPaneManager.titledPane(
    title: String? = null
): TitledPane = addPane(KtfxTitledPane(title))

/** Add a [TitledPane] with initialization block to this manager. */
inline fun TitledPaneManager.titledPane(
    title: String? = null,
    init: (@LayoutDslMarker KtfxTitledPane).() -> Unit
): TitledPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addPane(KtfxTitledPane(title), init)
}
