@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [Pane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxPane : Pane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }
}

/** Create a [Pane] with configuration block. */
inline fun pane(
    configuration: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxPane().apply(configuration)
}

/** Add a [Pane] to this manager. */
fun NodeManager.pane(): Pane = addChild(KtfxPane())

/** Add a [Pane] with configuration block to this manager. */
inline fun NodeManager.pane(
    configuration: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxPane(), configuration)
}
