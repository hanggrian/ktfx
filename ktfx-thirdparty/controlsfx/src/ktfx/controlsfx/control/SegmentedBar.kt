@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.SegmentedBar
import org.controlsfx.control.SegmentedBar.Segment

/** Add a [SegmentedBar] to this manager. */
fun <T : Segment> NodeManager.segmentedBar(): SegmentedBar<T> =
    SegmentedBar<T>().add()

/** Add a [SegmentedBar] with initialization block to this manager. */
inline fun <T : Segment> NodeManager.segmentedBar(
    init: (@LayoutDslMarker SegmentedBar<T>).() -> Unit
): SegmentedBar<T> = segmentedBar<T>().apply(init)
