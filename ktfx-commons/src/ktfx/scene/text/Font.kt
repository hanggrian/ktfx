@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.util.Builder
import ktfx.internal._CustomFontBuilder
import ktfx.internal._DefaultFontBuilder
import java.io.InputStream

interface FontBuilder : Builder<Font> {

    /** Font size that will ultimately be converted to [Double]. */
    operator fun plus(size: Number): FontBuilder
}

interface DefaultFontBuilder : FontBuilder {

    /** Font family. */
    operator fun plus(family: String): DefaultFontBuilder

    /** Font weight, may use value from enumeration [FontWeight] or typed interface below. */
    operator fun plus(weight: FontWeight): DefaultFontBuilder

    /** Font posture, may use value from enumeration [FontPosture] or typed interface below. */
    operator fun plus(posture: FontPosture): DefaultFontBuilder
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
inline fun buildFont(
    builderAction: FontStyles.(DefaultFontBuilder) -> FontBuilder
): Font = FontStyles.builderAction(_DefaultFontBuilder()).build()

inline fun buildFont(
    urlString: String,
    builderAction: FontStyles.(FontBuilder) -> FontBuilder
): Font = FontStyles.builderAction(_CustomFontBuilder().custom(urlString)).build()

inline fun buildFont(
    stream: InputStream,
    builderAction: FontStyles.(FontBuilder) -> FontBuilder
): Font = FontStyles.builderAction(_CustomFontBuilder().custom(stream)).build()