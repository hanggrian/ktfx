@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.ClosePath
import ktfx.PathElementInvokable
import ktfx.LayoutDsl

/** Creates a [ClosePath]. */
fun closePath(
    init: ((@LayoutDsl ClosePath).() -> Unit)? = null
): ClosePath = ClosePath().also { init?.invoke(it) }

/** Creates a [ClosePath] and add it to this manager. */
inline fun PathElementInvokable.closePath(
    noinline init: ((@LayoutDsl ClosePath).() -> Unit)? = null
): ClosePath = ktfx.layouts.closePath(init)()