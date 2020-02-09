@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TextField
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [TextField] with configurationialization block. */
inline fun textField(
    text: String = "",
    configuration: (@LayoutDslMarker TextField).() -> Unit
): TextField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return TextField(text).apply(configuration)
}

/** Add a [TextField] to this manager. */
fun NodeManager.textField(
    text: String = ""
): TextField = addChild(TextField(text))

/** Add a [TextField] with configurationialization block to this manager. */
inline fun NodeManager.textField(
    text: String = "",
    configuration: (@LayoutDslMarker TextField).() -> Unit
): TextField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(TextField(text), configuration)
}
