@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXTextArea] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxTextArea(text: String? = null): JFXTextArea = jfxTextArea(text = text) { }

/**
 * Create a [JFXTextArea] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxTextArea(
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTextArea).() ->    
    Unit
): JFXTextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextArea(text)
    child.configuration()
    return child
}

/**
 * Add a [JFXTextArea] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxTextArea(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        JFXTextArea
    ).() -> Unit
): JFXTextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextArea(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTextArea].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXTextArea(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTextArea = styledJFXTextArea(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTextArea] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXTextArea(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTextArea = styledJFXTextArea(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTextArea] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXTextArea(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTextArea).() -> Unit
): JFXTextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextArea(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTextArea] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXTextArea(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTextArea).() -> Unit
): JFXTextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextArea(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
