@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.layout.Region
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [Region]. */
fun region(
    init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = Region().also { init?.invoke(it) }

/** Creates a [Region] and add it to this manager. */
inline fun NodeInvokable.region(
    noinline init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = ktfx.layouts.region(init)()