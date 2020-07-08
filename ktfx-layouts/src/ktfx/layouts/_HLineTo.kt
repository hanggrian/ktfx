@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.HLineTo
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [HLineTo] to this manager.
 */
fun PathElementManager.hlineTo(x: Double = 0.0): HLineTo = hlineTo(x = x) { }

/**
 * Create a [HLineTo] with configuration block.
 */
inline fun hlineTo(x: Double = 0.0, configuration: (@LayoutDslMarker HLineTo).() -> Unit): HLineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(HLineTo(x), configuration = configuration)
}

/**
 * Add a [HLineTo] with configuration block to this manager.
 */
inline fun PathElementManager.hlineTo(
    x: Double = 0.0,
    configuration: (
        @LayoutDslMarker    
        HLineTo
    ).() -> Unit
): HLineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(HLineTo(x), configuration = configuration))
}
