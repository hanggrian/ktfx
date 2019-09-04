@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.ClosePath

/** Add a [ClosePath] to this manager. */
fun PathElementManager.closePath(): ClosePath =
    ClosePath().add()

/** Add a [ClosePath] with initialization block to this manager. */
inline fun PathElementManager.closePath(
    init: (@LayoutDslMarker ClosePath).() -> Unit
): ClosePath = closePath().apply(init)
