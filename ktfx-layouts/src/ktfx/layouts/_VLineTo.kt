@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
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

/**
 * Add a [VLineTo] to this manager.
 *
 * @return the control added.
 */
public fun PathElementManager.vlineTo(y: Double = 0.0): VLineTo = vlineTo(y = y) { }

/**
 * Create a [VLineTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun vlineTo(
    y: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker VLineTo).() ->    
    Unit
): VLineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = VLineTo(y)
    child.configuration()
    return child
}

/**
 * Add a [VLineTo] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun PathElementManager.vlineTo(
    y: Double = 0.0,
    configuration: (
        @KtfxLayoutDslMarker    
        VLineTo
    ).() -> Unit
): VLineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = VLineTo(y)
    child.configuration()
    return addChild(child)
}
