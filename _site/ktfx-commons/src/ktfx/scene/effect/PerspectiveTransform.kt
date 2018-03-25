@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.Effect
import javafx.scene.effect.PerspectiveTransform

/** The input for this [Effect]. */
inline operator fun PerspectiveTransform.component1(): Effect? = input

/** The x coordinate of the output location onto which the upper left corner of the source is mapped. */
inline operator fun PerspectiveTransform.component2(): Double = ulx

/** The y coordinate of the output location onto which the upper left corner of the source is mapped. */
inline operator fun PerspectiveTransform.component3(): Double = uly

/** The x coordinate of the output location onto which the upper right corner of the source is mapped. */
inline operator fun PerspectiveTransform.component4(): Double = urx

/** The y coordinate of the output location onto which the upper right corner of the source is mapped. */
inline operator fun PerspectiveTransform.component5(): Double = ury

/** The x coordinate of the output location onto which the lower right corner of the source is mapped. */
inline operator fun PerspectiveTransform.component6(): Double = lrx

/** The y coordinate of the output location onto which the lower right corner of the source is mapped. */
inline operator fun PerspectiveTransform.component7(): Double = lry

/** The x coordinate of the output location onto which the lower left corner of the source is mapped. */
inline operator fun PerspectiveTransform.component8(): Double = llx

/** The y coordinate of the output location onto which the lower left corner of the source is mapped. */
inline operator fun PerspectiveTransform.component9(): Double = lly