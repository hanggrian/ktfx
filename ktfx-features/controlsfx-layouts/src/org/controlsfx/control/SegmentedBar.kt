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
import org.controlsfx.control.SegmentedBar
import org.controlsfx.control.SegmentedBar.Segment

/** Create a [SegmentedBar] with initialization block. */
inline fun <T : Segment> segmentedBar(
    init: (@LayoutDslMarker SegmentedBar<T>).() -> Unit
): SegmentedBar<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return SegmentedBar<T>().apply(init)
}
/** Add a [SegmentedBar] to this manager. */
fun <T : Segment> NodeManager.segmentedBar(): SegmentedBar<T> =
    addNode(SegmentedBar())

/** Add a [SegmentedBar] with initialization block to this manager. */
inline fun <T : Segment> NodeManager.segmentedBar(
    init: (@LayoutDslMarker SegmentedBar<T>).() -> Unit
): SegmentedBar<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(SegmentedBar(), init)
}
