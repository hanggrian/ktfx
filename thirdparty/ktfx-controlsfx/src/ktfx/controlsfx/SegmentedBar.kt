@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.SegmentedBar
import org.controlsfx.control.SegmentedBar.Segment

/** Creates a [SegmentedBar]. */
fun <T : Segment> segmentedBar(
    init: ((@LayoutDsl SegmentedBar<T>).() -> Unit)? = null
): SegmentedBar<T> = SegmentedBar<T>().also {
    init?.invoke(it)
}

/** Creates a [SegmentedBar] and add it to this [LayoutManager]. */
inline fun <T : Segment> LayoutManager<Node>.segmentedBar(
    noinline init: ((@LayoutDsl SegmentedBar<T>).() -> Unit)? = null
): SegmentedBar<T> = ktfx.controlsfx.segmentedBar(init)()