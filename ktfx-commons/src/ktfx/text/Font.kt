@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import java.io.InputStream
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Returns a default [Font] with size of this [Int] number. */
val Int.pt: Font get() = toDouble().pt

/** Returns a default [Font] with size of this [Double] number. */
inline val Double.pt: Font get() = Font.font(this)

/** Returns a [Font] with specified [family], [weight] and [size] of an [Int] number. */
fun fontOf(family: String? = null, weight: FontWeight? = null, size: Int): Font =
    fontOf(family, weight, size.toDouble())

/** Returns a [Font] with specified [family], [weight] and [size] of a [Double] number. */
inline fun fontOf(family: String? = null, weight: FontWeight? = null, size: Double = -1.0): Font =
    Font.font(family, weight, size)

/** Returns an italic [Font] with specified [family], [weight] and [size] of an [Int] number. */
fun italicFontOf(family: String? = null, weight: FontWeight? = null, size: Int): Font =
    italicFontOf(family, weight, size.toDouble())

/** Returns an italic [Font] with specified [family], [weight] and [size] of a [Double] number. */
inline fun italicFontOf(family: String? = null, weight: FontWeight? = null, size: Double = -1.0): Font =
    Font.font(family, weight, FontPosture.ITALIC, size)

/** Load font from [url], specifying [size] of an [Int] number. */
fun loadFont(url: String, size: Int): Font = loadFont(url, size.toDouble())

/** Load font from [url], specifying [size] of a [Double] number. */
inline fun loadFont(url: String, size: Double = 0.0): Font = Font.loadFont(url, size)

/** Load font from [stream], specifying [size] of an [Int] number. */
fun loadFont(stream: InputStream, size: Int): Font = loadFont(stream, size.toDouble())

/** Load font from [stream], specifying [size] of a [Double] number. */
inline fun loadFont(stream: InputStream, size: Double = 0.0): Font = Font.loadFont(stream, size)
