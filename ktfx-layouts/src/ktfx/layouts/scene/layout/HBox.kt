@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.HBox

open class _HBox(spacing: Double) : HBox(spacing), HBoxConstraints {

    override fun <R : Node> R.invoke(): R = also { children += it }
}

/** Creates a [HBox]. */
fun hbox(
    spacing: Double = 0.0,
    init: ((@LayoutMarker _HBox).() -> Unit)? = null
): HBox = _HBox(spacing).also { init?.invoke(it) }

/** Creates a [HBox] and add it to this manager. */
inline fun NodeInvokable.hbox(
    spacing: Double = 0.0,
    noinline init: ((@LayoutMarker _HBox).() -> Unit)? = null
): HBox = ktfx.layouts.hbox(spacing, init)()