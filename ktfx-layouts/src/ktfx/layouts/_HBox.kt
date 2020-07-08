@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.HBox
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [HBox] to this manager.
 */
fun NodeManager.hbox(spacing: Double = 0.0): HBox = hbox(spacing = spacing) { }

/**
 * Create a [HBox] with configuration block.
 */
inline fun hbox(spacing: Double = 0.0, configuration: (@LayoutDslMarker KtfxHBox).() -> Unit):
    HBox {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(KtfxHBox(spacing), configuration = configuration)
    }

/**
 * Add a [HBox] with configuration block to this manager.
 */
inline fun NodeManager.hbox(
    spacing: Double = 0.0,
    configuration: (@LayoutDslMarker KtfxHBox).() ->    
    Unit
): HBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxHBox(spacing), configuration = configuration))
}

/**
 * Create a styled [HBox].
 */
fun styledHBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): HBox = styledHBox(spacing = spacing, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [HBox] to this manager.
 */
fun NodeManager.styledHBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): HBox = styledHBox(spacing = spacing, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [HBox] with configuration block.
 */
inline fun styledHBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxHBox(spacing), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [HBox] with configuration block to this manager.
 */
inline fun NodeManager.styledHBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxHBox(spacing), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
