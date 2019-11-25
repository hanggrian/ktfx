@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import java.io.InputStream
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Returns default font with double size. */
val Double.pt: Font get() = Font.font(this)

/** Returns default font with any number size. */
inline val Number.pt: Font get() = toDouble().pt

/** Returns font with specified [family], [weight] and double [size]. */
fun fontOf(family: String? = null, weight: FontWeight? = null, size: Double = -1.0): Font =
    Font.font(family, weight, size)

/** Returns font with specified [family], [weight] and any number [size]. */
inline fun fontOf(family: String? = null, weight: FontWeight? = null, size: Number): Font =
    fontOf(family, weight, size.toDouble())

/** Returns italic font with specified [family], [weight] and double [size]. */
fun italicFontOf(family: String? = null, weight: FontWeight? = null, size: Double = -1.0): Font =
    Font.font(family, weight, FontPosture.ITALIC, size)

/** Returns italic font with specified [family], [weight] and any number [size]. */
inline fun italicFontOf(family: String? = null, weight: FontWeight? = null, size: Number): Font =
    italicFontOf(family, weight, size.toDouble())

/** Load font from [url], specifying double [size]. */
fun loadFont(url: String, size: Double = 0.0): Font = Font.loadFont(url, size)

/** Load font from [url], specifying any number [size]. */
inline fun loadFont(url: String, size: Number): Font = loadFont(url, size.toDouble())

/** Load font from [stream], specifying double [size]. */
fun loadFont(stream: InputStream, size: Double = 0.0): Font = Font.loadFont(stream, size)

/** Load font from [stream], specifying any number [size]. */
inline fun loadFont(stream: InputStream, size: Number): Font = loadFont(stream, size.toDouble())
