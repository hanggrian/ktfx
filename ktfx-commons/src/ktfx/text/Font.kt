@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Returns a default font with size of this [Int] number. */
val Int.pt: Font get() = Font.font(toDouble())

/** Returns a default font with size of this [Double] number. */
inline val Double.pt: Font get() = Font.font(this)

/** Compose a font of [family], [this] weight, default posture, and default size. */
operator fun FontWeight.plus(family: String): Font = Font.font(family, this, 12.0)

/** Compose a font of default family, [this] weight, [posture], and default size. */
operator fun FontWeight.plus(posture: FontPosture): Font = Font.font(Font.getDefault().family, this, posture, 12.0)

/** Compose a font of default family, [this] weight, default posture, and [size]. */
operator fun FontWeight.plus(size: Double): Font = Font.font(Font.getDefault().family, this, size)

/** Compose a font of default family, [this] weight, default posture, and [size]. */
operator fun FontWeight.plus(size: Int): Font = Font.font(Font.getDefault().family, this, size.toDouble())

/** Compose a font of [family], default weight, [this] posture, and default size. */
operator fun FontPosture.plus(family: String): Font = Font.font(family, this, 12.0)

/** Compose a font of default family, [weight], [this] posture, and default size. */
operator fun FontPosture.plus(weight: FontWeight): Font = Font.font(Font.getDefault().family, weight, this, 12.0)

/** Compose a font of default family, default weight, [this] posture, and [size]. */
operator fun FontPosture.plus(size: Double): Font = Font.font(Font.getDefault().family, this, size)

/** Compose a font of default family, default weight, [this] posture, and [size]. */
operator fun FontPosture.plus(size: Int): Font = Font.font(Font.getDefault().family, this, size.toDouble())

/** Compose a font of [family], default weight, default posture, and [this] size. */
operator fun Double.plus(family: String): Font = Font.font(family, this)

/** Compose a font of default family, [weight], default posture, and [this] size. */
operator fun Double.plus(weight: FontWeight): Font = Font.font(Font.getDefault().family, weight, this)

/** Compose a font of default family, default weight, [posture], and [this] size. */
operator fun Double.plus(posture: FontPosture): Font = Font.font(Font.getDefault().family, posture, this)

/** Compose a font of [family], default weight, default posture, and [this] size. */
operator fun Int.plus(family: String): Font = Font.font(family, toDouble())

/** Compose a font of default family, [weight], default posture, and [this] size. */
operator fun Int.plus(weight: FontWeight): Font = Font.font(Font.getDefault().family, weight, toDouble())

/** Compose a font of default family, default weight, [posture], and [this] size. */
operator fun Int.plus(posture: FontPosture): Font = Font.font(Font.getDefault().family, posture, toDouble())

/** Compose a font of [family], [this] font's weight, [this] font's posture, and [this] font's size. */
operator fun Font.plus(family: String): Font = Font.font(family, weight, posture, size)

/** Compose a font of [this] font's family, [weight], [this] font's posture, and [this] font's size. */
operator fun Font.plus(weight: FontWeight): Font = Font.font(family, weight, posture, size)

/** Compose a font of [this] font's family, [this] font's weight, [posture], and [this] font's size. */
operator fun Font.plus(posture: FontPosture): Font = Font.font(family, weight, posture, size)

/** Compose a font of [this] font's family, [this] font's weight, [this] font's posture, and [size]. */
operator fun Font.plus(size: Double): Font = Font.font(family, weight, posture, size)

/** Compose a font of [this] font's family, [this] font's weight, [this] font's posture, and [size]. */
operator fun Font.plus(size: Int): Font = Font.font(family, weight, posture, size.toDouble())

internal val Font.weight: FontWeight
    get() = when {
        "Light" in style -> when {
            "Extra" in style || "Ultra" in style -> FontWeight.EXTRA_LIGHT
            else -> FontWeight.LIGHT
        }
        "Bold" in style -> when {
            "Semi" in style || "Demi" in style -> FontWeight.SEMI_BOLD
            "Extra" in style || "Ultra" in style -> FontWeight.EXTRA_BOLD
            else -> FontWeight.BOLD
        }
        "Black" in style || "Heavy" in style -> FontWeight.BLACK
        "Thin" in style -> FontWeight.THIN
        "Medium" in style -> FontWeight.MEDIUM
        else -> FontWeight.NORMAL
    }

internal val Font.posture: FontPosture
    get() = when {
        "Italic" in style -> FontPosture.ITALIC
        else -> FontPosture.REGULAR
    }
