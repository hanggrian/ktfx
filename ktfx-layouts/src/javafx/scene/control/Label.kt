@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Label] with initialization block. */
inline fun label(
    text: String? = null,
    graphic: Node? = null,
    init: Label.() -> Unit
): Label {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Label(text, graphic).apply(init)
}

/** Add a [Label] to this manager. */
fun NodeManager.label(
    text: String? = null,
    graphic: Node? = null
): Label = addNode(Label(text, graphic))

/** Add a [Label] with initialization block to this manager. */
inline fun NodeManager.label(
    text: String? = null,
    graphic: Node? = null,
    init: Label.() -> Unit
): Label {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Label(text, graphic), init)
}
