@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Separator] to this manager.
 */
fun NodeManager.separator(orientation: Orientation = HORIZONTAL): Separator = separator(
    orientation =
        orientation
) { }

/**
 * Create a [Separator] with configuration block.
 */
inline fun separator(
    orientation: Orientation = HORIZONTAL,
    configuration: (
        @LayoutDslMarker    
        Separator
    ).() -> Unit
): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Separator(orientation), configuration = configuration)
}

/**
 * Add a [Separator] with configuration block to this manager.
 */
inline fun NodeManager.separator(
    orientation: Orientation = HORIZONTAL,
    configuration: (@LayoutDslMarker Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Separator(orientation), configuration = configuration))
}

/**
 * Create a styled [Separator].
 */
fun styledSeparator(
    orientation: Orientation = HORIZONTAL,
    vararg styleClass: String,
    id: String? = null
): Separator = styledSeparator(orientation = orientation, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Separator] to this manager.
 */
fun NodeManager.styledSeparator(
    orientation: Orientation = HORIZONTAL,
    vararg styleClass: String,
    id: String? = null
): Separator = styledSeparator(orientation = orientation, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Separator] with configuration block.
 */
inline fun styledSeparator(
    orientation: Orientation = HORIZONTAL,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        Separator(orientation), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [Separator] with configuration block to this manager.
 */
inline fun NodeManager.styledSeparator(
    orientation: Orientation = HORIZONTAL,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Separator(orientation), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}
