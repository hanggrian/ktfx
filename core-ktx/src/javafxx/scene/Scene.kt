@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")

package javafxx.scene

import javafx.scene.Scene
import javafx.scene.image.WritableImage

/** Take a screenshot of this [Scene] without writable image target. */
inline fun Scene.snapshot(image: WritableImage? = null): WritableImage = snapshot(image)