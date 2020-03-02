@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [ColorPicker] to this manager.
 */
fun NodeManager.colorPicker(value: Color = WHITE): ColorPicker = colorPicker(value = value) { }

/**
 * Create a [ColorPicker] with configuration block.
 */
inline fun colorPicker(
    value: Color = WHITE,
    configuration: (@LayoutDslMarker ColorPicker).() ->    
            Unit
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ColorPicker(value), configuration = configuration)
}

/**
 * Add a [ColorPicker] with configuration block to this manager.
 */
inline fun NodeManager.colorPicker(
    value: Color = WHITE,
    configuration: (@LayoutDslMarker    
            ColorPicker).() -> Unit
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ColorPicker(value), configuration = configuration))
}

/**
 * Create a styled [ColorPicker].
 */
fun styledColorPicker(value: Color = WHITE, vararg styleClass: String): ColorPicker =
        styledColorPicker(value = value, styleClass = *styleClass) { }

/**
 * Add a styled [ColorPicker] to this manager.
 */
fun NodeManager.styledColorPicker(value: Color = WHITE, vararg styleClass: String): ColorPicker =
        styledColorPicker(value = value, styleClass = *styleClass) { }

/**
 * Create a styled [ColorPicker] with configuration block.
 */
inline fun styledColorPicker(
    value: Color = WHITE,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker ColorPicker).() -> Unit
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ColorPicker(value), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [ColorPicker] with configuration block to this manager.
 */
inline fun NodeManager.styledColorPicker(
    value: Color = WHITE,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker ColorPicker).() -> Unit
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ColorPicker(value), styleClass = *styleClass, configuration =
            configuration))
}
