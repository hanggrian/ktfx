@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.transform

import javafx.scene.Node
import javafx.scene.transform.Translate

inline fun Node.translate(): Translate = Translate().also { transforms += it }

inline fun Node.translate(x: Double, y: Double): Translate = Translate(x, y).also { transforms += it }

inline fun Node.translate(x: Double, y: Double, z: Double): Translate = Translate(x, y, z).also { transforms += it }
