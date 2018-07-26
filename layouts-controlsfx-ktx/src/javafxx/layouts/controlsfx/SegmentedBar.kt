@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
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
): SegmentedBar<T> = javafxx.layouts.controlsfx.segmentedBar(init)()

/** Create a styled [SegmentedBar]. */
fun <T : Segment> styledSegmentedBar(
    styleClass: String,
    init: ((@LayoutDsl SegmentedBar<T>).() -> Unit)? = null
): SegmentedBar<T> = SegmentedBar<T>().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [SegmentedBar] and add it to this [LayoutManager]. */
inline fun <T : Segment> LayoutManager<Node>.styledSegmentedBar(
    styleClass: String,
    noinline init: ((@LayoutDsl SegmentedBar<T>).() -> Unit)? = null
): SegmentedBar<T> = javafxx.layouts.controlsfx.styledSegmentedBar(styleClass, init)()