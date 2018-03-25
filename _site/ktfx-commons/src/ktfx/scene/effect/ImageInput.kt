@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.Node
import javafx.scene.effect.ImageInput
import javafx.scene.image.Image

/** The source [Image]. */
inline operator fun ImageInput.component1(): Image? = source

/** Sets the x location of the source image, relative to the local coordinate space of the content [Node]. */
inline operator fun ImageInput.component2(): Double = x

/** Sets the y location of the source image, relative to the local coordinate space of the content [Node]. */
inline operator fun ImageInput.component3(): Double = y