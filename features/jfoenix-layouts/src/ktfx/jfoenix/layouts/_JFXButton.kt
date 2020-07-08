@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXButton] to this manager.
 */
fun NodeManager.jfxButton(text: String? = null, graphic: Node? = null): JFXButton = jfxButton(
    text =
        text,
    graphic = graphic
) { }

/**
 * Create a [JFXButton] with configuration block.
 */
inline fun jfxButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXButton(text, graphic), configuration = configuration)
}

/**
 * Add a [JFXButton] with configuration block to this manager.
 */
inline fun NodeManager.jfxButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXButton(text, graphic), configuration = configuration))
}

/**
 * Create a styled [JFXButton].
 */
fun styledJFXButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): JFXButton = styledJFXButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
}

/**
 * Add a styled [JFXButton] to this manager.
 */
fun NodeManager.styledJFXButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): JFXButton = styledJFXButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) {
}

/**
 * Create a styled [JFXButton] with configuration block.
 */
inline fun styledJFXButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        JFXButton(text, graphic), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXButton] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXButton).() -> Unit
): JFXButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            JFXButton(text, graphic), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}
