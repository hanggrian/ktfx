@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.util.Builder
import ktfx.internal._FontBuilder
import java.io.InputStream

/** Interface for building [Font] with infix functions. */
interface FontBuilder : Builder<Font> {

    /**
     * Load font from url string.
     * When triggered, all other builder action except [size] will not be processed.
     * @see Font.loadFont
     */
    infix fun load(custom: String): FontBuilder

    /**
     * Load font from input stream.
     * When triggered, all other builder action except [size] will not be processed.
     * @see Font.loadFont
     */
    infix fun load(custom: InputStream): FontBuilder

    /** Font family. */
    infix fun family(family: String): FontBuilder

    /** Font weight, may use value from enumeration [FontWeight] or typed interface below. */
    infix fun weight(weight: FontWeight): FontBuilder

    /** Font posture, may use value from enumeration [FontPosture] or typed interface below. */
    infix fun posture(posture: FontPosture): FontBuilder

    /** Font size that will ultimately be converted to [Double]. */
    infix fun size(size: Number): FontBuilder
}

object FontStyles {

    val thin: FontWeight get() = FontWeight.THIN
    val extraLight: FontWeight get() = FontWeight.EXTRA_LIGHT
    val light: FontWeight get() = FontWeight.LIGHT
    val normal: FontWeight get() = FontWeight.NORMAL
    val medium: FontWeight get() = FontWeight.MEDIUM
    val semiBold: FontWeight get() = FontWeight.SEMI_BOLD
    val bold: FontWeight get() = FontWeight.BOLD
    val extraBold: FontWeight get() = FontWeight.EXTRA_BOLD
    val black: FontWeight get() = FontWeight.BLACK

    val regular: FontPosture get() = FontPosture.REGULAR
    val italic: FontPosture get() = FontPosture.ITALIC
}

/** Build [Font] with Kotlin infix functions. */
inline fun buildFont(builderAction: FontStyles.(FontBuilder) -> FontBuilder): Font =
    FontStyles.builderAction(_FontBuilder()).build()