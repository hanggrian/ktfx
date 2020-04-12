@file:JvmMultifileClass
@file:JvmName("FontKt")

package ktfx.text

import javafx.scene.control.Labeled
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

/** Font family of this [Labeled]. */
inline var Labeled.fontFamily: String
    get() = font.family
    set(value) {
        font = Font.font(value, font.weight, font.posture, font.size)
    }

/** Font weight of this [Labeled], parsed from its style string. */
inline var Labeled.fontWeight: FontWeight
    get() = font.weight
    set(value) {
        font = Font.font(font.family, value, font.posture, font.size)
    }

/** Font posture of this [Labeled], parsed from its style string. */
inline var Labeled.fontPosture: FontPosture
    get() = font.posture
    set(value) {
        font = Font.font(font.family, font.weight, value, font.size)
    }

/** Font size of this [Labeled]. */
inline var Labeled.fontSize: Double
    get() = font.size
    set(value) {
        font = Font.font(font.family, font.weight, font.posture, value)
    }
