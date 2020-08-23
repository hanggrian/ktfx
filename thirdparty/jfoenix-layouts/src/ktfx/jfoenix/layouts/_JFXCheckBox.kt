@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXCheckBox
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
 * Add a [JFXCheckBox] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxCheckBox(text: String? = null): JFXCheckBox = jfxCheckBox(text = text) { }

/**
 * Create a [JFXCheckBox] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxCheckBox(
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXCheckBox).() ->    
    Unit
): JFXCheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXCheckBox(text)
    child.configuration()
    return child
}

/**
 * Add a [JFXCheckBox] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxCheckBox(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        JFXCheckBox
    ).() -> Unit
): JFXCheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXCheckBox(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXCheckBox].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXCheckBox = styledJFXCheckBox(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXCheckBox] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXCheckBox = styledJFXCheckBox(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXCheckBox] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXCheckBox).() -> Unit
): JFXCheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXCheckBox(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXCheckBox] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXCheckBox).() -> Unit
): JFXCheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXCheckBox(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
