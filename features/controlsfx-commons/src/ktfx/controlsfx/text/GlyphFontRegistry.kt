package ktfx.controlsfx.text

import org.controlsfx.glyphfont.GlyphFont
import org.controlsfx.glyphfont.GlyphFontRegistry

/** Registers the specified font. */
fun GlyphFont.register(): Unit = GlyphFontRegistry.register(this)
