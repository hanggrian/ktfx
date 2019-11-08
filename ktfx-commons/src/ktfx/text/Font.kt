@file:JvmMultifileClass
@file:JvmName("FontKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Returns default font with specified size. */
val Double.pt: Font
    get() = Font.font(this)

/** Returns default font with specified size. */
inline val Int.pt: Font
    get() = toDouble().pt

/** Returns font with specified [family], [weight] and [size]. */
fun fontOf(
    family: String? = null,
    weight: FontWeight? = null,
    size: Double = -1.0
): Font = Font.font(family, weight, size)

/** Returns font with specified [family] and [size]. */
inline fun fontOf(
    family: String? = null,
    size: Double = -1.0
): Font = fontOf(family, null, size)

/** Returns font with specified [weight] and [size]. */
inline fun fontOf(
    weight: FontWeight? = null,
    size: Double = -1.0
): Font = fontOf(null, weight, size)

/** Returns italic font with specified [family], [weight] and [size]. */
fun italicFontOf(
    family: String? = null,
    weight: FontWeight? = null,
    size: Double = -1.0
): Font = Font.font(family, weight, FontPosture.ITALIC, size)

/** Returns italic font with specified [family] and [size]. */
inline fun italicFontOf(
    family: String? = null,
    size: Double = -1.0
): Font = italicFontOf(family, null, size)

/** Returns italic font with specified [weight] and [size]. */
inline fun italicFontOf(
    weight: FontWeight? = null,
    size: Double = -1.0
): Font = italicFontOf(null, weight, size)
