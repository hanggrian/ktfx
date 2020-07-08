@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.Rating
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Rating] to this manager.
 */
fun NodeManager.rating(max: Int = 5, rating: Int = -1): Rating = rating(max = max, rating = rating) { }

/**
 * Create a [Rating] with configuration block.
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
 */
fun styledRating(
    max: Int = 5,
    rating: Int = -1,
    vararg styleClass: String,
    id: String? = null
): Rating = styledRating(max = max, rating = rating, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Rating] to this manager.
 */
fun NodeManager.styledRating(
    max: Int = 5,
    rating: Int = -1,
    vararg styleClass: String,
    id: String? = null
): Rating = styledRating(max = max, rating = rating, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Rating] with configuration block.
 */
inline fun styledRating(
    max: Int = 5,
    rating: Int = -1,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Rating).() -> Unit
): Rating {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        Rating(max, rating), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [Rating] with configuration block to this manager.
 */
inline fun NodeManager.styledRating(
    max: Int = 5,
    rating: Int = -1,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Rating).() -> Unit
): Rating {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Rating(max, rating), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}
