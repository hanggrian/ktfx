@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.text.Text
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Text] with initialization block. */
inline fun text(
    text: String? = null,
    init: (@LayoutDslMarker Text).() -> Unit
): Text {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Text(text).apply(init)
}
/** Add a [Text] to this manager. */
fun NodeManager.text(
    text: String? = null
): Text = addNode(Text(text))

/** Add a [Text] with initialization block to this manager. */
inline fun NodeManager.text(
    text: String? = null,
    init: (@LayoutDslMarker Text).() -> Unit
): Text {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Text(text), init)
}
