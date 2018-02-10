@file:Suppress("NOTHING_TO_INLINE")

package kotfx.scene

import javafx.scene.control.Labeled
import javafx.scene.control.TextInputControl
import javafx.scene.control.Tooltip
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import java.io.InputStream

//region search and set font with appropriate options
inline fun Labeled.setFont(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

inline fun Text.setFont(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

inline fun TextInputControl.setFont(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))

inline fun Tooltip.setFont(
    family: String? = null,
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) = setFont(Font.font(family, weight, posture, size.toDouble()))
//endregion

//region load font from url string
inline fun Labeled.loadFont(
    url: String,
    size: Number
) = setFont(Font.loadFont(url, size.toDouble()))

inline fun Text.loadFont(
    url: String,
    size: Number
) = setFont(Font.loadFont(url, size.toDouble()))

inline fun TextInputControl.loadFont(
    url: String,
    size: Number
) = setFont(Font.loadFont(url, size.toDouble()))

inline fun Tooltip.loadFont(
    url: String,
    size: Number
) = setFont(Font.loadFont(url, size.toDouble()))
//endregion

//region load font from input stream
inline fun Labeled.loadFont(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))

inline fun Text.loadFont(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))

inline fun TextInputControl.loadFont(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))

inline fun Tooltip.loadFont(
    stream: InputStream,
    size: Number
) = setFont(Font.loadFont(stream, size.toDouble()))
//endregion