@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PlusMinusSlider

/**
 * Add a [PlusMinusSlider] to this manager.
 */
fun NodeManager.plusMinusSlider(): PlusMinusSlider = plusMinusSlider() { }

/**
 * Create a [PlusMinusSlider] with configuration block.
 */
inline fun plusMinusSlider(configuration: (@LayoutDslMarker PlusMinusSlider).() -> Unit):
        PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(PlusMinusSlider(), configuration = configuration)
}

/**
 * Add a [PlusMinusSlider] with configuration block to this manager.
 */
inline fun NodeManager.plusMinusSlider(
    configuration: (@LayoutDslMarker PlusMinusSlider).() ->
Unit
): PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(PlusMinusSlider(), configuration = configuration))
}

/**
 * Create a styled [PlusMinusSlider].
 */
fun styledPlusMinusSlider(vararg styleClass: String, id: String? = null): PlusMinusSlider =
        styledPlusMinusSlider(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [PlusMinusSlider] to this manager.
 */
fun NodeManager.styledPlusMinusSlider(vararg styleClass: String, id: String? = null):
        PlusMinusSlider = styledPlusMinusSlider(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [PlusMinusSlider] with configuration block.
 */
inline fun styledPlusMinusSlider(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(PlusMinusSlider(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [PlusMinusSlider] with configuration block to this manager.
 */
inline fun NodeManager.styledPlusMinusSlider(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(PlusMinusSlider(), styleClass = *styleClass, id = id, configuration =
            configuration))
}
