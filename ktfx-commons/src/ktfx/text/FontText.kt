@file:JvmMultifileClass
@file:JvmName("FontKt")

package ktfx.text

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.Text

/** Sets [Text] current font family while keeping other attributes. */
inline var Text.fontFamily: String
    get() = font.family
    set(value) {
        font = Font.font(value, font.weight, font.posture, font.size)
    }

/** Sets [Text] current font weight while keeping other attributes. */
inline var Text.fontWeight: FontWeight
    get() = font.weight
    set(value) {
        font = Font.font(font.family, value, font.posture, font.size)
    }

/** Sets [Text] current font posture while keeping other attributes. */
inline var Text.fontPosture: FontPosture
    get() = font.posture
    set(value) {
        font = Font.font(font.family, font.weight, value, font.size)
    }

/** Sets [Text] current font size while keeping other attributes. */
inline var Text.fontSize: Double
    get() = font.size
    set(value) {
        font = Font.font(font.family, font.weight, font.posture, value)
    }
