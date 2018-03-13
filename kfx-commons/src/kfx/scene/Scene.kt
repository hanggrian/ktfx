@file:Suppress("NOTHING_TO_INLINE")

package kfx.scene

import javafx.scene.Scene
import javafx.scene.image.WritableImage

/** Take a screenshot of this [Scene] returning image it wrote. */
inline fun Scene.screenshot(
    image: WritableImage? = null
): WritableImage = snapshot(image)