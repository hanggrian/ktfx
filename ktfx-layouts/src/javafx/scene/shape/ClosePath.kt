@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.shape.ClosePath

/** Create a [ClosePath] with initialization block. */
inline fun closePath(
    init: (@LayoutDslMarker ClosePath).() -> Unit
): ClosePath = ClosePath().apply(init)

/** Add a [ClosePath] to this manager. */
fun PathElementManager.closePath(): ClosePath =
    addElement(ClosePath())

/** Add a [ClosePath] with initialization block to this manager. */
inline fun PathElementManager.closePath(
    init: (@LayoutDslMarker ClosePath).() -> Unit
): ClosePath = addElement(ClosePath(), init)
