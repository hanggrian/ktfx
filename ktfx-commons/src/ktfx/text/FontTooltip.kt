@file:JvmMultifileClass
@file:JvmName("FontKt")

package ktfx.text

import javafx.scene.control.Tooltip
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Sets [Tooltip] current font family while keeping other attributes. */
inline var Tooltip.fontFamily: String
    get() = font.family
    set(value) {
        font = Font.font(value, font.weight, font.posture, font.size)
    }

/** Sets [Tooltip] current font weight while keeping other attributes. */
inline var Tooltip.fontWeight: FontWeight
    get() = font.weight
    set(value) {
        font = Font.font(font.family, value, font.posture, font.size)
    }

/** Sets [Tooltip] current font posture while keeping other attributes. */
inline var Tooltip.fontPosture: FontPosture
    get() = font.posture
    set(value) {
        font = Font.font(font.family, font.weight, value, font.size)
    }

/** Sets [Tooltip] current font size while keeping other attributes. */
inline var Tooltip.fontSize: Double
    get() = font.size
    set(value) {
        font = Font.font(font.family, font.weight, font.posture, value)
    }
