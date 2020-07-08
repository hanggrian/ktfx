@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ColorPicker] to this manager.
 */
fun NodeManager.colorPicker(color: Color = WHITE): ColorPicker = colorPicker(color = color) { }

/**
 * Create a [ColorPicker] with configuration block.
 */
inline fun colorPicker(
    color: Color = WHITE,
    configuration: (@LayoutDslMarker ColorPicker).() ->    
    Unit
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ColorPicker(color), configuration = configuration)
}

/**
 * Add a [ColorPicker] with configuration block to this manager.
 */
inline fun NodeManager.colorPicker(
    color: Color = WHITE,
    configuration: (
        @LayoutDslMarker    
        ColorPicker
    ).() -> Unit
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ColorPicker(color), configuration = configuration))
}

/**
 * Create a styled [ColorPicker].
 */
fun styledColorPicker(
    color: Color = WHITE,
    vararg styleClass: String,
    id: String? = null
): ColorPicker = styledColorPicker(color = color, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ColorPicker] to this manager.
 */
fun NodeManager.styledColorPicker(
    color: Color = WHITE,
    vararg styleClass: String,
    id: String? = null
): ColorPicker = styledColorPicker(color = color, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ColorPicker] with configuration block.
 */
inline fun styledColorPicker(
    color: Color = WHITE,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ColorPicker).() -> Unit
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        ColorPicker(color), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [ColorPicker] with configuration block to this manager.
 */
inline fun NodeManager.styledColorPicker(
    color: Color = WHITE,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ColorPicker).() -> Unit
): ColorPicker {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            ColorPicker(color), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
