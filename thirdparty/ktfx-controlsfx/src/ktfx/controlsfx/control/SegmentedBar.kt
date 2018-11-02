@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.NodeInvokable
import ktfx.LayoutDsl
import org.controlsfx.control.SegmentedBar
import org.controlsfx.control.SegmentedBar.Segment

/** Creates a [SegmentedBar]. */
fun <T : Segment> segmentedBar(
    init: ((@LayoutDsl SegmentedBar<T>).() -> Unit)? = null
): SegmentedBar<T> = SegmentedBar<T>().also { init?.invoke(it) }

/** Creates a [SegmentedBar] and add it to this manager. */
inline fun <T : Segment> NodeInvokable.segmentedBar(
    noinline init: ((@LayoutDsl SegmentedBar<T>).() -> Unit)? = null
): SegmentedBar<T> = ktfx.controlsfx.segmentedBar(init)()