@file:JvmMultifileClass
@file:JvmName("Glyphs")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx.text

import org.controlsfx.glyphfont.Glyph
import org.controlsfx.glyphfont.GlyphFont
import org.controlsfx.glyphfont.GlyphFontRegistry

/** Creates an instance of [Glyph] using specified font character. */
public inline infix fun GlyphFont.glyph(character: Char): Glyph = create(character)

/** Creates an instance of [Glyph] using glyph name. */
public inline infix fun GlyphFont.glyph(glyphName: String): Glyph = create(glyphName)

/** Creates an instance of [Glyph] using a known Glyph enum value. */
public inline infix fun GlyphFont.glyph(glyph: Enum<*>): Glyph = create(glyph)

/** Registers the specified font. */
public inline fun GlyphFont.register(): Unit = GlyphFontRegistry.register(this)
