@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXCheckBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXCheckBox] with initialization block. */
inline fun jfxCheckBox(
    text: String? = null,
    init: JFXCheckBox.() -> Unit
): JFXCheckBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXCheckBox(text).apply(init)
}

/** Add a [JFXCheckBox] to this manager. */
fun NodeManager.jfxCheckBox(
    text: String? = null
): JFXCheckBox = addNode(JFXCheckBox(text))

/** Add a [JFXCheckBox] with initialization block to this manager. */
inline fun NodeManager.jfxCheckBox(
    text: String? = null,
    init: JFXCheckBox.() -> Unit
): JFXCheckBox {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXCheckBox(text), init)
}
