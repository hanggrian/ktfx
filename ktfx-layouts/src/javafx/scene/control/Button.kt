@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Button] with configuration block. */
inline fun button(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Button).() -> Unit
): Button {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Button(text, graphic).apply(configuration)
}

/** Add a [Button] to this manager. */
fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null
): Button = addChild(Button(text, graphic))

/** Add a [Button] with configuration block to this manager. */
inline fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Button).() -> Unit
): Button {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Button(text, graphic), configuration)
}
