@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [TextFlow] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxTextFlow : TextFlow(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    /** Call [NodeManager.text] by string invocation. */
    inline operator fun String.invoke(
        init: (@KtfxLayoutsDslMarker Text).() -> Unit
    ): Text = text(this, init)
}

/** Create a [TextFlow] with initialization block. */
inline fun textFlow(
    init: (@KtfxLayoutsDslMarker KtfxTextFlow).() -> Unit
): TextFlow {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxTextFlow().apply(init)
}

/** Add a [TextFlow] to this manager. */
fun NodeManager.textFlow(): TextFlow =
    addNode(KtfxTextFlow())

/** Add a [TextFlow] with initialization block to this manager. */
inline fun NodeManager.textFlow(
    init: (@KtfxLayoutsDslMarker KtfxTextFlow).() -> Unit
): TextFlow {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxTextFlow(), init)
}
