@file:JvmMultifileClass
@file:JvmName("ScenesKt")
@file:Suppress("UsePropertyAccessSyntax")

package kotfx

import javafx.scene.control.Labeled
import javafx.scene.control.TextInputControl
import javafx.scene.control.Tooltip
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import java.io.InputStream
import java.net.URL

interface Fonted<out T> {

    fun size(size: Number): T
}

class _SystemFont : Fonted<_SystemFont> {

    private var _name: String? = null
    private var _weight: FontWeight? = null
    private var _posture: FontPosture? = null
    private var _size: Number = -1

    infix fun name(name: String): _SystemFont = apply { _name = name }
    infix fun weight(weight: FontWeight): _SystemFont = apply { _weight = weight }
    infix fun posture(posture: FontPosture): _SystemFont = apply { _posture = posture }
    override infix fun size(size: Number): _SystemFont = apply { _size = size }
}

/** Search appropriate font with options and set it to this [Labeled]. */
fun Labeled.font(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

/** Search appropriate font with options and set it to this [Text]. */
fun Text.font(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

/** Search appropriate font with options and set it to this [TextInputControl]. */
fun TextInputControl.font(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

/** Search appropriate font with options and set it to this [Tooltip]. */
fun Tooltip.font(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

/** Load font from url string and set it to this [Labeled]. */
fun Labeled.font(
    url: URL,
    size: Number
) = setFont(Font.loadFont(url.toExternalForm(), size.toDouble()))

/** Load font from url string and set it to this [Text]. */
fun Text.font(
    url: URL,
    size: Number
) = setFont(Font.loadFont(url.toExternalForm(), size.toDouble()))

/** Load font from url string and set it to this [TextInputControl]. */
fun TextInputControl.font(
    url: URL,
    size: Number
) = setFont(Font.loadFont(url.toExternalForm(), size.toDouble()))

/** Load font from url string and set it to this [Tooltip]. */
fun Tooltip.font(
    url: URL,
    size: Number
) = setFont(Font.loadFont(url.toExternalForm(), size.toDouble()))

/** Load font from input stream and set it to this [Labeled]. */
fun Labeled.font(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))

/** Load font from input stream and set it to this [Text]. */
fun Text.font(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))

/** Load font from input stream and set it to this [TextInputControl]. */
fun TextInputControl.loadFont(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))

/** Load font from input stream and set it to this [Tooltip]. */
fun Tooltip.font(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))