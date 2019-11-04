@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

open class KtfxJFXBadge : JFXBadge(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { control = it }
}

/** Create a [JFXBadge] with initialization block. */
inline fun jfxBadge(
    init: (@LayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return KtfxJFXBadge().apply(init)
}
/** Add a [JFXBadge] to this manager. */
fun NodeManager.jfxBadge(): JFXBadge =
    addNode(KtfxJFXBadge())

/** Add a [JFXBadge] with initialization block to this manager. */
inline fun NodeManager.jfxBadge(
    init: (@LayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(KtfxJFXBadge(), init)
}
