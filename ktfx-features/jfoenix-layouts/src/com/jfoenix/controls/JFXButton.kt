@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXButton] with initialization block. */
inline fun jfxButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXButton(text, graphic).apply(init)
}
/** Add a [JFXButton] to this manager. */
fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null
): JFXButton = addNode(JFXButton(text, graphic))

/** Add a [JFXButton] with initialization block to this manager. */
inline fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXButton(text, graphic), init)
}
