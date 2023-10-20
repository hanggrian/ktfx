@file:JvmMultifileClass
@file:JvmName("FontKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Returns a default font with size of this [Int] number. */
val Int.pt: Font get() = Font.font(toDouble())

/** Returns a default font with size of this [Double] number. */
inline val Double.pt: Font get() = Font.font(this)

/** Composes a font from configuration using [Int] size. */
fun fontOf(
    family: String = "System",
    weight: FontWeight = FontWeight.NORMAL,
    posture: FontPosture = FontPosture.REGULAR,
    size: Int,
): Font = Font.font(family, weight, posture, size.toDouble())

/** Composes a font from configuration using [Double] size. */
inline fun fontOf(
    family: String = "System",
    weight: FontWeight = FontWeight.NORMAL,
    posture: FontPosture = FontPosture.REGULAR,
    size: Double = Font.getDefault().size,
): Font = Font.font(family, weight, posture, size)
