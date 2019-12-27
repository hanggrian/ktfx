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
    configuration: (@LayoutsDslMarker Text).() -> Unit
): Text {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Text(text).apply(configuration)
}

/** Add a [Text] to this manager. */
fun NodeManager.text(
    text: String? = null
): Text = addChild(Text(text))

/** Add a [Text] with initialization block to this manager. */
inline fun NodeManager.text(
    text: String? = null,
    configuration: (@LayoutsDslMarker Text).() -> Unit
): Text {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Text(text), configuration)
}
