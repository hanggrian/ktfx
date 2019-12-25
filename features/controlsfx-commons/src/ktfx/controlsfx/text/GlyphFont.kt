@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.text

import org.controlsfx.glyphfont.Glyph
import org.controlsfx.glyphfont.GlyphFont

/** Creates an instance of [Glyph] using specified font character. */
inline infix fun GlyphFont.create(character: Char): Glyph = create(character)

/** Creates an instance of [Glyph] using glyph name. */
inline infix fun GlyphFont.create(glyphName: String): Glyph = create(glyphName)

/** Creates an instance of [Glyph] using a known Glyph enum value. */
inline infix fun GlyphFont.create(glyph: Enum<*>): Glyph = create(glyph)
