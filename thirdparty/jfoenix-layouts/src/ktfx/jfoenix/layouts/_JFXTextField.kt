@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextField
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
 * Add a [JFXTextField] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxTextField(text: String? = null): JFXTextField = jfxTextField(text = text) { }

/**
 * Create a [JFXTextField] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxTextField(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        JFXTextField
    ).() -> Unit
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextField(text)
    child.configuration()
    return child
}

/**
 * Add a [JFXTextField] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxTextField(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        JFXTextField
    ).() -> Unit
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextField(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTextField].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTextField = styledJFXTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTextField] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTextField = styledJFXTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTextField] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTextField).() -> Unit
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextField(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTextField] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTextField).() -> Unit
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTextField(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
