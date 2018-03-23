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