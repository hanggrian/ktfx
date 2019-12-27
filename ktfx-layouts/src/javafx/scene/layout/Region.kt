@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.Region
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Region] with initialization block. */
inline fun region(
    configuration: (@LayoutsDslMarker Region).() -> Unit
): Region {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Region().apply(configuration)
}

/** Add a [Region] to this manager. */
fun NodeManager.region(): Region = addChild(Region())

/** Add a [Region] with initialization block to this manager. */
inline fun NodeManager.region(
    configuration: (@LayoutsDslMarker Region).() -> Unit
): Region {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Region(), configuration)
}
