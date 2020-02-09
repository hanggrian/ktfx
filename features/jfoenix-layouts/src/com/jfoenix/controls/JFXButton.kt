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
import ktfx.layouts.addChild

/** Create a [JFXButton] with configurationialization block. */
inline fun jfxButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXButton(text, graphic).apply(configuration)
}

/** Add a [JFXButton] to this manager. */
fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null
): JFXButton = addChild(JFXButton(text, graphic))

/** Add a [JFXButton] with configurationialization block to this manager. */
inline fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXButton(text, graphic), configuration)
}
