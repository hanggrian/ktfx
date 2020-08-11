@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.HLineTo
import kotlin.Double
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [HLineTo] to this manager.
 *
 * @return the control added.
 */
fun PathElementManager.hlineTo(x: Double = 0.0): HLineTo = hlineTo(x = x) { }

/**
 * Create a [HLineTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun hlineTo(x: Double = 0.0, configuration: (@LayoutDslMarker HLineTo).() -> Unit): HLineTo {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(HLineTo(x), configuration = configuration)
}

/**
 * Add a [HLineTo] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun PathElementManager.hlineTo(x: Double = 0.0, configuration: (@LayoutDslMarker
    HLineTo).() -> Unit): HLineTo {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(HLineTo(x), configuration = configuration))
}
