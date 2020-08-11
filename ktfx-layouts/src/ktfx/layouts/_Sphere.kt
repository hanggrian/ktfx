@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Sphere
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Sphere] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.sphere(radius: Double = 1.0, division: Int = 64): Sphere = sphere(radius = radius,
    division = division) { }

/**
 * Create a [Sphere] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun sphere(
  radius: Double = 1.0,
  division: Int = 64,
  configuration: (@LayoutDslMarker Sphere).() -> Unit
): Sphere {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Sphere(radius, division), configuration = configuration)
}

/**
 * Add a [Sphere] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.sphere(
  radius: Double = 1.0,
  division: Int = 64,
  configuration: (@LayoutDslMarker Sphere).() -> Unit
): Sphere {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Sphere(radius, division), configuration = configuration))
}

/**
 * Create a styled [Sphere].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledSphere(
  radius: Double = 1.0,
  division: Int = 64,
  vararg styleClass: String,
  id: String? = null
): Sphere = styledSphere(radius = radius, division = division, styleClass = *styleClass, id = id) {
    }

/**
 * Add a styled [Sphere] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledSphere(
  radius: Double = 1.0,
  division: Int = 64,
  vararg styleClass: String,
  id: String? = null
): Sphere = styledSphere(radius = radius, division = division, styleClass = *styleClass, id = id) {
    }

/**
 * Create a styled [Sphere] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledSphere(
  radius: Double = 1.0,
  division: Int = 64,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Sphere).() -> Unit
): Sphere {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Sphere(radius, division), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [Sphere] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledSphere(
  radius: Double = 1.0,
  division: Int = 64,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Sphere).() -> Unit
): Sphere {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Sphere(radius, division), styleClass = *styleClass, id = id,
      configuration = configuration))
}
