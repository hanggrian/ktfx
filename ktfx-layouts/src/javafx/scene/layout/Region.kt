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
    init: Region.() -> Unit
): Region {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Region().apply(init)
}

/** Add a [Region] to this manager. */
fun NodeManager.region(): Region =
    addNode(Region())

/** Add a [Region] with initialization block to this manager. */
inline fun NodeManager.region(
    init: Region.() -> Unit
): Region {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Region(), init)
}
