@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.text.Text
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Text] with configuration block. */
inline fun text(
    text: String? = null,
    configuration: (@LayoutDslMarker Text).() -> Unit
): Text {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Text(text).apply(configuration)
}

/** Add a [Text] to this manager. */
fun NodeManager.text(
    text: String? = null
): Text = addChild(Text(text))

/** Add a [Text] with configuration block to this manager. */
inline fun NodeManager.text(
    text: String? = null,
    configuration: (@LayoutDslMarker Text).() -> Unit
): Text {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Text(text), configuration)
}
