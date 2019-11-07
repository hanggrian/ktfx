@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.Rating

/** Create a [Rating] with initialization block. */
inline fun rating(
    max: Int = 5,
    rating: Int = -1,
    init: (@LayoutDslMarker Rating).() -> Unit
): Rating {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Rating(max, rating).apply(init)
}
/** Add a [Rating] to this manager. */
fun NodeManager.rating(
    max: Int = 5,
    rating: Int = -1
): Rating = addNode(Rating(max, rating))

/** Add a [Rating] with initialization block to this manager. */
inline fun NodeManager.rating(
    max: Int = 5,
    rating: Int = -1,
    init: (@LayoutDslMarker Rating).() -> Unit
): Rating {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Rating(max, rating), init)
}
