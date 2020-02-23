@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Create a styled [Button].
 */
fun styledButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String
): Button = styledButton(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [Button] to this manager.
 */
fun NodeManager.styledButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String
): Button = styledButton(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Create a styled [Button] with configuration block.
 */
inline fun styledButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Button).() -> Unit
): Button {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Button(text, graphic), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [Button] with configuration block to this manager.
 */
inline fun NodeManager.styledButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker Button).() -> Unit
): Button {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Button(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a [Button] to this manager.
 */
fun NodeManager.button(text: String? = null, graphic: Node? = null): Button = button(text = text,
        graphic = graphic) { }

/**
 * Create a [Button] with configuration block.
 */
inline fun button(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Button).() -> Unit
): Button {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Button(text, graphic), configuration = configuration)
}

/**
 * Add a [Button] with configuration block to this manager.
 */
inline fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker Button).() -> Unit
): Button {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Button(text, graphic), configuration = configuration))
}
