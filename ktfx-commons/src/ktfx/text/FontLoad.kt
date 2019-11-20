@file:JvmMultifileClass
@file:JvmName("FontKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import java.io.InputStream
import javafx.scene.text.Font

/** Load font from [url], specifying double [size]. */
fun loadFont(
    url: String,
    size: Double = 0.0
): Font = Font.loadFont(url, size)

/** Load font from [stream], specifying double [size]. */
fun loadFont(
    stream: InputStream,
    size: Double = 0.0
): Font = Font.loadFont(stream, size)

/** Load font from [url], specifying any number [size]. */
fun loadFont(
    url: String,
    size: Number
): Font = loadFont(url, size.toDouble())

/** Load font from [stream], specifying any number [size]. */
fun loadFont(
    stream: InputStream,
    size: Number
): Font = loadFont(stream, size.toDouble())
