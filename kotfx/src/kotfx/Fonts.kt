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