@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.transform

import javafx.scene.Node
import javafx.scene.transform.Shear

inline fun Node.shear(): Shear = Shear().also { transforms += it }

inline fun Node.shear(x: Double, y: Double): Shear = Shear(x, y).also { transforms += it }

inline fun Node.shear(x: Double, y: Double, pivotX: Double, pixotY: Double): Shear =
    Shear(x, y, pivotX, pixotY).also { transforms += it }