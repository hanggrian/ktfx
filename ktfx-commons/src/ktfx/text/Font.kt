@file:JvmMultifileClass
@file:JvmName("FontKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Returns default font with double size. */
val Double.pt: Font
    get() = Font.font(this)

/** Returns default font with any number size. */
inline val Number.pt: Font
    get() = toDouble().pt

/** Returns font with specified [family], [weight] and double [size]. */
fun fontOf(
    family: String? = null,
    weight: FontWeight? = null,
    size: Double = -1.0
): Font = Font.font(family, weight, size)

/** Returns italic font with specified [family], [weight] and double [size]. */
fun italicFontOf(
    family: String? = null,
    weight: FontWeight? = null,
    size: Double = -1.0
): Font = Font.font(family, weight, FontPosture.ITALIC, size)

/** Returns font with specified [family], [weight] and any number [size]. */
fun fontOf(
    family: String? = null,
    weight: FontWeight? = null,
    size: Number
): Font = fontOf(family, weight, size.toDouble())

/** Returns italic font with specified [family], [weight] and any number [size]. */
fun italicFontOf(
    family: String? = null,
    weight: FontWeight? = null,
    size: Number
): Font = italicFontOf(family, weight, size.toDouble())
