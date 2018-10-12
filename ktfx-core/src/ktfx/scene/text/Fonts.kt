@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import java.io.InputStream

/** [Font] is final, hence the existence of this object. */
object Fonts {

    inline operator fun invoke(
        size: Double = -1.0,
        family: String? = null,
        weight: FontWeight? = null,
        posture: FontPosture? = null
    ): Font = Font.font(family, weight, posture, size)

    operator fun invoke(
        size: Number = -1.0,
        family: String? = null,
        weight: FontWeight? = null,
        posture: FontPosture? = null
    ): Font = invoke(size.toDouble(), family, weight, posture)

    inline operator fun invoke(
        url: String,
        size: Double = -1.0 // force [Font.getDefaultSystemFontSize]
    ): Font = Font.loadFont(url, size)

    inline operator fun invoke(
        url: String,
        size: Number = -1.0 // force [Font.getDefaultSystemFontSize]
    ): Font = invoke(url, size.toDouble())

    inline operator fun invoke(
        stream: InputStream,
        size: Double = -1.0 // force [Font.getDefaultSystemFontSize]
    ): Font = Font.loadFont(stream, size)

    inline operator fun invoke(
        stream: InputStream,
        size: Number = -1.0 // force [Font.getDefaultSystemFontSize]
    ): Font = invoke(stream, size.toDouble())
}