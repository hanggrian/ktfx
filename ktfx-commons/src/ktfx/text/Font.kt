@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import java.io.InputStream
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Returns a default font with size of this [Int] number. */
val Int.pt: Font get() = Font.font(toDouble())

/** Returns a default font with size of this [Double] number. */
inline val Double.pt: Font get() = Font.font(this)

/** Returns a font with specified [family], [weight] and [size] of an [Int] number. */
fun fontOf(family: String? = null, weight: FontWeight? = null, size: Int): Font =
    Font.font(family, weight, size.toDouble())

/** Returns a font with specified [family], [weight] and [size] of a [Double] number. */
inline fun fontOf(family: String? = null, weight: FontWeight? = null, size: Double = -1.0): Font =
    Font.font(family, weight, size)

/** Returns an italic font with specified [family], [weight] and [size] of an [Int] number. */
fun italicFontOf(family: String? = null, weight: FontWeight? = null, size: Int): Font =
    Font.font(family, weight, FontPosture.ITALIC, size.toDouble())

/** Returns an italic font with specified [family], [weight] and [size] of a [Double] number. */
inline fun italicFontOf(family: String? = null, weight: FontWeight? = null, size: Double = -1.0): Font =
    Font.font(family, weight, FontPosture.ITALIC, size)

/** Load a font from [url], specifying [size] of an [Int] number. */
fun loadFont(url: String, size: Int): Font = Font.loadFont(url, size.toDouble())

/** Load a font from [url], specifying [size] of a [Double] number. */
inline fun loadFont(url: String, size: Double = 0.0): Font = Font.loadFont(url, size)

/** Load a font from [stream], specifying [size] of an [Int] number. */
fun loadFont(stream: InputStream, size: Int): Font = Font.loadFont(stream, size.toDouble())

/** Load a font from [stream], specifying [size] of a [Double] number. */
inline fun loadFont(stream: InputStream, size: Double = 0.0): Font = Font.loadFont(stream, size)
