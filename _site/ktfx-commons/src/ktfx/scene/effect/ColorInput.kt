@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.Node
import javafx.scene.effect.ColorInput
import javafx.scene.paint.Paint

/** The [Paint] used to flood the region. */
inline operator fun ColorInput.component1(): Paint = paint

/** Sets the x location of the region to be flooded, relative to the local coordinate space of the content [Node]. */
inline operator fun ColorInput.component2(): Double = x

/** Sets the y location of the region to be flooded, relative to the local coordinate space of the content [Node]. */
inline operator fun ColorInput.component3(): Double = y

/** Sets the width of the region to be flooded, relative to the local coordinate space of the content [Node]. */
inline operator fun ColorInput.component4(): Double = width

/** Sets the height of the region to be flooded, relative to the local coordinate space of the content [Node]. */
inline operator fun ColorInput.component5(): Double = height