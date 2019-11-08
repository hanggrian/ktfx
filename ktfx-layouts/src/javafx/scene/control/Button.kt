@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Button] with initialization block. */
inline fun button(
    text: String? = null,
    graphic: Node? = null,
    init: Button.() -> Unit
): Button {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Button(text, graphic).apply(init)
}
/** Add a [Button] to this manager. */
fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null
): Button = addNode(Button(text, graphic))

/** Add a [Button] with initialization block to this manager. */
inline fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null,
    init: Button.() -> Unit
): Button {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Button(text, graphic), init)
}
