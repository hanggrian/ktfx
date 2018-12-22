@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.transform

import javafx.geometry.Point3D
import javafx.scene.Node
import javafx.scene.transform.Rotate

inline fun Node.rotate(): Rotate = Rotate().also { transforms += it }

inline fun Node.rotate(angle: Double): Rotate = Rotate(angle).also { transforms += it }

inline fun Node.rotate(angle: Double, axis: Point3D): Rotate = Rotate(angle, axis).also { transforms += it }

inline fun Node.rotate(angle: Double, pivotX: Double, pivotY: Double): Rotate =
    Rotate(angle, pivotX, pivotY).also { transforms += it }

inline fun Node.rotate(angle: Double, pivotX: Double, pivotY: Double, pivotZ: Double): Rotate =
    Rotate(angle, pivotX, pivotY, pivotZ).also { transforms += it }

inline fun Node.rotate(angle: Double, pivotX: Double, pivotY: Double, pivotZ: Double, axis: Point3D): Rotate =
    Rotate(angle, pivotX, pivotY, pivotZ, axis).also { transforms += it }