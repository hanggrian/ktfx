@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.DisplacementMap
import javafx.scene.effect.Effect
import javafx.scene.effect.FloatMap

/** The input for this [Effect]. */
inline operator fun DisplacementMap.component1(): Effect? = input

/** The map data for this [Effect]. */
inline operator fun DisplacementMap.component2(): FloatMap = mapData

/** The scale factor by which all x coordinate offset values in the [FloatMap] are multiplied. */
inline operator fun DisplacementMap.component3(): Double = scaleX

/** The scale factor by which all y coordinate offset values in the [FloatMap] are multiplied. */
inline operator fun DisplacementMap.component4(): Double = scaleY

/** The offset by which all x coordinate offset values in the [FloatMap] are displaced after they are scaled. */
inline operator fun DisplacementMap.component5(): Double = offsetX

/** The offset by which all y coordinate offset values in the [FloatMap] are displaced after they are scaled. */
inline operator fun DisplacementMap.component6(): Double = offsetY

/** Defines whether values taken from outside the edges of the map "wrap around" or not. */
inline operator fun DisplacementMap.component7(): Boolean = isWrap