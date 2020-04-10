@file:JvmMultifileClass
@file:JvmName("FontKt")

package ktfx.text

import javafx.scene.control.Labeled
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Sets [Labeled] current font family while keeping other attributes. */
inline var Labeled.fontFamily: String
    get() = font.family
    set(value) {
        font = Font.font(value, font.weight, font.posture, font.size)
    }

/** Sets [Labeled] current font weight while keeping other attributes. */
inline var Labeled.fontWeight: FontWeight
    get() = font.weight
    set(value) {
        font = Font.font(font.family, value, font.posture, font.size)
    }

/** Sets [Labeled] current font posture while keeping other attributes. */
inline var Labeled.fontPosture: FontPosture
    get() = font.posture
    set(value) {
        font = Font.font(font.family, font.weight, value, font.size)
    }

/** Sets [Labeled] current font size while keeping other attributes. */
inline var Labeled.fontSize: Double
    get() = font.size
    set(value) {
        font = Font.font(font.family, font.weight, font.posture, value)
    }
