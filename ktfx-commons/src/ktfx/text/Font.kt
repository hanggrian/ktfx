@file:JvmMultifileClass
@file:JvmName("FontKt")

package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Returns a default font with size of this [Int] number. */
val Int.pt: Font get() = Font.font(toDouble())

/** Returns a default font with size of this [Double] number. */
inline val Double.pt: Font get() = Font.font(this)

/** Returns [FontWeight] parsed from [Font.style]. */
val Font.weight: FontWeight
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

/** Returns [FontPosture] parsed from [Font.style]. */
val Font.posture: FontPosture
    get() = when {
        "Italic" in style -> FontPosture.ITALIC
        else -> FontPosture.REGULAR
    }
