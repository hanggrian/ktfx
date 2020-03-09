@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.VLineTo
import kotlin.Double
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [VLineTo] to this manager.
 */
fun PathElementManager.vlineTo(y: Double = 0.0): VLineTo = vlineTo(y = y) { }

/**
 * Create a [VLineTo] with configuration block.
 */
inline fun vlineTo(y: Double = 0.0, configuration: (@LayoutDslMarker VLineTo).() -> Unit): VLineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(VLineTo(y), configuration = configuration)
}

/**
 * Add a [VLineTo] with configuration block to this manager.
 */
inline fun PathElementManager.vlineTo(
    y: Double = 0.0,
    configuration: (@LayoutDslMarker    
            VLineTo).() -> Unit
): VLineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(VLineTo(y), configuration = configuration))
}
