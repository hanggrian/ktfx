@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.shape.HLineTo

/** Create a [HLineTo] with initialization block. */
inline fun hlineTo(
    x: Double = 0.0,
    init: (@LayoutDslMarker HLineTo).() -> Unit
): HLineTo = HLineTo(x).apply(init)

/** Add a [HLineTo] to this manager. */
fun PathElementManager.hlineTo(
    x: Double = 0.0
): HLineTo = addElement(HLineTo(x))

/** Add a [HLineTo] with initialization block to this manager. */
inline fun PathElementManager.hlineTo(
    x: Double = 0.0,
    init: (@LayoutDslMarker HLineTo).() -> Unit
): HLineTo = addElement(HLineTo(x), init)
