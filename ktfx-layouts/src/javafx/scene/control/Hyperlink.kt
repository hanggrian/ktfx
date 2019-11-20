@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Hyperlink] with initialization block. */
inline fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: (@KtfxLayoutsDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Hyperlink(text, graphic).apply(init)
}

/** Add a [Hyperlink] to this manager. */
fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null
): Hyperlink = addNode(Hyperlink(text, graphic))

/** Add a [Hyperlink] with initialization block to this manager. */
inline fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: (@KtfxLayoutsDslMarker Hyperlink).() -> Unit
): Hyperlink {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Hyperlink(text, graphic), init)
}
