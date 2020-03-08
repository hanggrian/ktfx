@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.CheckBox
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [CheckBox] to this manager.
 */
fun NodeManager.checkBox(text: String? = null): CheckBox = checkBox(text = text) { }

/**
 * Create a [CheckBox] with configuration block.
 */
inline fun checkBox(text: String? = null, configuration: (@LayoutDslMarker CheckBox).() -> Unit):
        CheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CheckBox(text), configuration = configuration)
}

/**
 * Add a [CheckBox] with configuration block to this manager.
 */
inline fun NodeManager.checkBox(
    text: String? = null,
    configuration: (@LayoutDslMarker    
            CheckBox).() -> Unit
): CheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CheckBox(text), configuration = configuration))
}

/**
 * Create a styled [CheckBox].
 */
fun styledCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): CheckBox = styledCheckBox(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CheckBox] to this manager.
 */
fun NodeManager.styledCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): CheckBox = styledCheckBox(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CheckBox] with configuration block.
 */
inline fun styledCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckBox).() -> Unit
): CheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CheckBox(text), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [CheckBox] with configuration block to this manager.
 */
inline fun NodeManager.styledCheckBox(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckBox).() -> Unit
): CheckBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CheckBox(text), styleClass = *styleClass, id = id, configuration =
            configuration))
}
