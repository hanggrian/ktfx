@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.SegmentedBar
import org.controlsfx.control.SegmentedBar.Segment

/** Create a [SegmentedBar] with initialization block. */
inline fun <T : Segment> segmentedBar(
    configuration: (@LayoutsDslMarker SegmentedBar<T>).() -> Unit
): SegmentedBar<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return SegmentedBar<T>().apply(configuration)
}

/** Add a [SegmentedBar] to this manager. */
fun <T : Segment> NodeManager.segmentedBar(): SegmentedBar<T> = addChild(SegmentedBar())

/** Add a [SegmentedBar] with initialization block to this manager. */
inline fun <T : Segment> NodeManager.segmentedBar(
    configuration: (@LayoutsDslMarker SegmentedBar<T>).() -> Unit
): SegmentedBar<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(SegmentedBar(), configuration)
}
