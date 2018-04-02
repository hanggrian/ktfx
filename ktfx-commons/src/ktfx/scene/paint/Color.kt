@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.paint

import javafx.scene.paint.Color

/** The red component of the color. */
inline operator fun Color.component1(): Double = red

/** The green component of the color. */
inline operator fun Color.component2(): Double = green

/** The blue component of the color. */
inline operator fun Color.component3(): Double = blue

/** The opacity of the color. */
inline operator fun Color.component4(): Double = opacity

/** Return string representation of this color for CSS styling purposes. */
val Color.webFormat: String
    get() = when {
        isOpaque -> "#%02X%02X%02X".format((red * 255).toInt(), (green * 255).toInt(), (blue * 255).toInt())
        else -> "rgba(${(red * 255).toInt()}, ${(green * 255).toInt()}, ${(blue * 255).toInt()}, $opacity)"
    }