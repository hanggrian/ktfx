@file:Suppress("NOTHING_TO_INLINE")

package kfx.scene

import javafx.scene.Scene
import javafx.scene.image.WritableImage

/** Take a screenshot of this [Scene] without writable image target. */
@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
inline fun Scene.snapshot(image: WritableImage? = null): WritableImage = snapshot(image)