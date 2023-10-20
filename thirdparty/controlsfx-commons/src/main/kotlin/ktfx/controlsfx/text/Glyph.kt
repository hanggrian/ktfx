@file:JvmMultifileClass
@file:JvmName("Glyphs")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.text

import javafx.scene.paint.Color
import org.controlsfx.glyphfont.Glyph

/**
 * Retrieve glyph by font name and glyph name using one string where font name an glyph name are
 * separated by pipe.
 *
 * @receiver font name.
 * @param glyph name.
 */
inline infix fun String.glyph(glyph: String): Glyph = Glyph.create("$this|$glyph")

/** Sets the glyph icon font family. */
inline infix fun Glyph.family(family: String): Glyph = fontFamily(family)

/** Sets the glyph color. */
inline infix fun Glyph.color(color: Color): Glyph = color(color)

/** Sets glyph size. */
inline infix fun Glyph.size(size: Double): Glyph = size(size)

/** Sets glyph size using size factor based on default font size. */
inline infix fun Glyph.sizeFactor(factor: Int): Glyph = sizeFactor(factor)

/** Enables/disables the hover effect style. */
infix fun Glyph.useHoverEffect(useHoverEffect: Boolean): Glyph =
    when {
        useHoverEffect -> useHoverEffect()
        else -> apply { styleClass -= Glyph.STYLE_HOVER_EFFECT }
    }

/** Enables/disables the gradient effect style. */
infix fun Glyph.useGradientEffect(useGradientEffect: Boolean): Glyph =
    when {
        useGradientEffect -> useGradientEffect()
        else -> apply { styleClass -= Glyph.STYLE_GRADIENT }
    }
