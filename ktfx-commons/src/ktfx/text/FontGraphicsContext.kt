@file:JvmMultifileClass
@file:JvmName("FontKt")

package ktfx.text

import javafx.scene.canvas.GraphicsContext
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Font family of this [GraphicsContext]. */
inline var GraphicsContext.fontFamily: String
    get() = font.family
    set(value) {
        font = Font.font(value, font.weight, font.posture, font.size)
    }

/** Font weight of this [GraphicsContext], parsed from its style string. */
inline var GraphicsContext.fontWeight: FontWeight
    get() = font.weight
    set(value) {
        font = Font.font(font.family, value, font.posture, font.size)
    }

/** Font posture of this [GraphicsContext], parsed from its style string. */
inline var GraphicsContext.fontPosture: FontPosture
    get() = font.posture
    set(value) {
        font = Font.font(font.family, font.weight, value, font.size)
    }

/** Font size of this [GraphicsContext]. */
inline var GraphicsContext.fontSize: Double
    get() = font.size
    set(value) {
        font = Font.font(font.family, font.weight, font.posture, value)
    }
