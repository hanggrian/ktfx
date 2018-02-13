@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene

import javafx.scene.control.Labeled
import javafx.scene.control.TextInputControl
import javafx.scene.control.Tooltip
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import java.io.InputStream

//<editor-fold desc="Search appropriate font with options">
/** Search appropriate font with options and set it to this [Labeled]. */
inline fun Labeled.setFont(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

/** Search appropriate font with options and set it to this [Text]. */
inline fun Text.setFont(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

/** Search appropriate font with options and set it to this [TextInputControl]. */
inline fun TextInputControl.setFont(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

/** Search appropriate font with options and set it to this [Tooltip]. */
inline fun Tooltip.setFont(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))
//</editor-fold>

//<editor-fold desc="Load font from url string">
/** Load font from url string and set it to this [Labeled]. */
inline fun Labeled.loadFont(
    url: String,
    size: Number
) = setFont(Font.loadFont(url, size.toDouble()))

/** Load font from url string and set it to this [Text]. */
inline fun Text.loadFont(
    url: String,
    size: Number
) = setFont(Font.loadFont(url, size.toDouble()))

/** Load font from url string and set it to this [TextInputControl]. */
inline fun TextInputControl.loadFont(
    url: String,
    size: Number
) = setFont(Font.loadFont(url, size.toDouble()))

/** Load font from url string and set it to this [Tooltip]. */
inline fun Tooltip.loadFont(
    url: String,
    size: Number
) = setFont(Font.loadFont(url, size.toDouble()))
//</editor-fold>

//<editor-fold desc="Load font from input stream">
/** Load font from input stream and set it to this [Labeled]. */
inline fun Labeled.loadFont(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))

/** Load font from input stream and set it to this [Text]. */
inline fun Text.loadFont(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))

/** Load font from input stream and set it to this [TextInputControl]. */
inline fun TextInputControl.loadFont(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))

/** Load font from input stream and set it to this [Tooltip]. */
inline fun Tooltip.loadFont(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))
//</editor-fold>