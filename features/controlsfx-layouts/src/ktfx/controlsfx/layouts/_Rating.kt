@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.Rating

/**
 * Add a [Rating] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.rating(max: Int = 5, rating: Int = -1): Rating = rating(max = max, rating = rating)
    { }

/**
 * Create a [Rating] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun rating(
  max: Int = 5,
  rating: Int = -1,
  configuration: (@LayoutDslMarker Rating).() -> Unit
): Rating {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Rating(max, rating), configuration = configuration)
}

/**
 * Add a [Rating] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.rating(
  max: Int = 5,
  rating: Int = -1,
  configuration: (@LayoutDslMarker Rating).() -> Unit
): Rating {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Rating(max, rating), configuration = configuration))
}

/**
 * Create a styled [Rating].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledRating(
  max: Int = 5,
  rating: Int = -1,
  vararg styleClass: String,
  id: String? = null
): Rating = styledRating(max = max, rating = rating, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Rating] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledRating(
  max: Int = 5,
  rating: Int = -1,
  vararg styleClass: String,
  id: String? = null
): Rating = styledRating(max = max, rating = rating, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Rating] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledRating(
  max: Int = 5,
  rating: Int = -1,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Rating).() -> Unit
): Rating {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Rating(max, rating), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [Rating] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledRating(
  max: Int = 5,
  rating: Int = -1,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Rating).() -> Unit
): Rating {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Rating(max, rating), styleClass = *styleClass, id = id, configuration =
      configuration))
}
