@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.transform

import javafx.scene.Node
import javafx.scene.transform.Scale

inline fun Node.scale(x: Double, y: Double): Scale = Scale(x, y).also { transforms += it }

inline fun Node.scale(
    x: Double, y: Double,
    pivotX: Double, pivotY: Double
): Scale = Scale(x, y, pivotX, pivotY).also { transforms += it }

inline fun Node.scale(x: Double, y: Double, z: Double): Scale = Scale(x, y, z).also { transforms += it }

inline fun Node.scale(
    x: Double, y: Double, z: Double,
    pivotX: Double, pivotY: Double, pivotZ: Double
): Scale = Scale(x, y, z, pivotX, pivotY, pivotZ).also { transforms += it }