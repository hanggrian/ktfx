@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.HBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxHBox(spacing: Double) : HBox(spacing), HBoxConstraints {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }
}

/** Create an [HBox] with initialization block. */
inline fun hbox(
    spacing: Double = 0.0,
    init: (@LayoutDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxHBox(spacing).apply(init)
}
/** Add an [HBox] to this manager. */
fun NodeManager.hbox(
    spacing: Double = 0.0
): HBox = addNode(KtfxHBox(spacing))

/** Add an [HBox] with initialization block to this manager. */
inline fun NodeManager.hbox(
    spacing: Double = 0.0,
    init: (@LayoutDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxHBox(spacing), init)
}
