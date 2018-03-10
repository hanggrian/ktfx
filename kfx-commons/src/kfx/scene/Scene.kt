@file:Suppress("NOTHING_TO_INLINE")

package kfx.scene

import javafx.scene.Scene
import javafx.scene.image.WritableImage

inline fun Scene.screenshot(
    image: WritableImage? = null
): WritableImage = snapshot(image)