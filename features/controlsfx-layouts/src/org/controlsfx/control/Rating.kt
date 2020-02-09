@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.Rating

/** Create a [Rating] with configurationialization block. */
inline fun rating(
    max: Int = 5,
    rating: Int = -1,
    configuration: (@LayoutDslMarker Rating).() -> Unit
): Rating {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Rating(max, rating).apply(configuration)
}

/** Add a [Rating] to this manager. */
fun NodeManager.rating(
    max: Int = 5,
    rating: Int = -1
): Rating = addChild(Rating(max, rating))

/** Add a [Rating] with configurationialization block to this manager. */
inline fun NodeManager.rating(
    max: Int = 5,
    rating: Int = -1,
    configuration: (@LayoutDslMarker Rating).() -> Unit
): Rating {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Rating(max, rating), configuration)
}
