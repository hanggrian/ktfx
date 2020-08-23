@file:JvmMultifileClass
@file:JvmName("FontKt")

package ktfx.text

import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Labeled
import javafx.scene.control.TextInputControl
import javafx.scene.control.Tooltip
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text

/** Returns a default font with size of this [Int] number. */
val Int.pt: Font get() = Font.font(toDouble())

/** Returns a default font with size of this [Double] number. */
inline val Double.pt: Font get() = Font.font(this)

/** Configures font of this [GraphicsContext]. */
fun GraphicsContext.font(
    family: String = font.family,
    weight: FontWeight = font.weight,
    posture: FontPosture = font.posture,
    size: Number = font.size
) {
    font = Font.font(family, weight, posture, size.toDouble())
}

/** Configures font of this [Labeled]. */
fun Labeled.font(
    family: String = font.family,
    weight: FontWeight = font.weight,
    posture: FontPosture = font.posture,
    size: Number = font.size
) {
    font = Font.font(family, weight, posture, size.toDouble())
}

/** Configures font of this [Text]. */
fun Text.font(
    family: String = font.family,
    weight: FontWeight = font.weight,
    posture: FontPosture = font.posture,
    size: Number = font.size
) {
    font = Font.font(family, weight, posture, size.toDouble())
}

/** Configures font of this [TextInputControl]. */
fun TextInputControl.font(
    family: String = font.family,
    weight: FontWeight = font.weight,
    posture: FontPosture = font.posture,
    size: Number = font.size
) {
    font = Font.font(family, weight, posture, size.toDouble())
}

/** Configures font of this [Tooltip]. */
fun Tooltip.font(
    family: String = font.family,
    weight: FontWeight = font.weight,
    posture: FontPosture = font.posture,
    size: Number = font.size
) {
    font = Font.font(family, weight, posture, size.toDouble())
}

/**
 * Returns [FontWeight] by finding appropriate keyword in [Font.style].
 * The result may be OS dependant.
 */
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

/**
 * Returns [FontPosture] by finding appropriate keyword in [Font.style].
 * The result may be OS dependant.
 */
internal val Font.posture: FontPosture
    get() = when {
        "Italic" in style -> FontPosture.ITALIC
        else -> FontPosture.REGULAR
    }
