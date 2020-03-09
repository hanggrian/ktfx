@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.VBox
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [VBox] to this manager.
 */
fun NodeManager.vbox(spacing: Double = 0.0): VBox = vbox(spacing = spacing) { }

/**
 * Create a [VBox] with configuration block.
 */
inline fun vbox(spacing: Double = 0.0, configuration: (@LayoutDslMarker KtfxVBox).() -> Unit):
        VBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxVBox(spacing), configuration = configuration)
}

/**
 * Add a [VBox] with configuration block to this manager.
 */
inline fun NodeManager.vbox(
    spacing: Double = 0.0,
    configuration: (@LayoutDslMarker KtfxVBox).() ->    
            Unit
): VBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxVBox(spacing), configuration = configuration))
}

/**
 * Create a styled [VBox].
 */
fun styledVBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): VBox = styledVBox(spacing = spacing, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [VBox] to this manager.
 */
fun NodeManager.styledVBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): VBox = styledVBox(spacing = spacing, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [VBox] with configuration block.
 */
inline fun styledVBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxVBox).() -> Unit
): VBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxVBox(spacing), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [VBox] with configuration block to this manager.
 */
inline fun NodeManager.styledVBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxVBox).() -> Unit
): VBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxVBox(spacing), styleClass = *styleClass, id = id, configuration =
            configuration))
}
