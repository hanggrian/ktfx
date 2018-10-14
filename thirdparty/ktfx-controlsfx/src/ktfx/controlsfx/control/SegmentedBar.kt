@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.SegmentedBar
import org.controlsfx.control.SegmentedBar.Segment

/** Creates a [SegmentedBar]. */
fun <T : Segment> segmentedBar(
    init: ((@LayoutDsl SegmentedBar<T>).() -> Unit)? = null
): SegmentedBar<T> = SegmentedBar<T>().also { init?.invoke(it) }

/** Creates a [SegmentedBar] and add it to this manager. */
inline fun <T : Segment> NodeManager.segmentedBar(
    noinline init: ((@LayoutDsl SegmentedBar<T>).() -> Unit)? = null
): SegmentedBar<T> = ktfx.controlsfx.segmentedBar(init)()