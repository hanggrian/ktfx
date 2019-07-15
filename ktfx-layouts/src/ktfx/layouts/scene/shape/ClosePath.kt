@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.ClosePath

/** Creates a [ClosePath]. */
fun closePath(
    init: ((@LayoutDslMarker ClosePath).() -> Unit)? = null
): ClosePath = ClosePath().also { init?.invoke(it) }

/** Creates a [ClosePath] and add it to this manager. */
inline fun PathElementManager.closePath(
    noinline init: ((@LayoutDslMarker ClosePath).() -> Unit)? = null
): ClosePath = ktfx.layouts.closePath(init).add()
