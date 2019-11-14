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
 * Making use of [kotlin.text.appendln] by implementing [Appendable].
 */
open class KtfxTextFlow : TextFlow(), NodeManager, Appendable {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    override fun append(text: CharSequence?): Appendable =
        apply { text(text?.toString()) }

    override fun append(csq: CharSequence, start: Int, end: Int): Appendable =
        throw UnsupportedOperationException()

    override fun append(c: Char): Appendable =
        append(c.toString())

    /** Call [NodeManager.text] by string invocation. */
    inline operator fun String.invoke(init: Text.() -> Unit): Text =
        text(this, init)
}

/** Create a [TextFlow] with initialization block. */
inline fun textFlow(
    init: KtfxTextFlow.() -> Unit
): TextFlow {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxTextFlow().apply(init)
}

/** Add a [TextFlow] to this manager. */
fun NodeManager.textFlow(): TextFlow =
    addNode(KtfxTextFlow())

/** Add a [TextFlow] with initialization block to this manager. */
inline fun NodeManager.textFlow(
    init: KtfxTextFlow.() -> Unit
): TextFlow {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxTextFlow(), init)
}
