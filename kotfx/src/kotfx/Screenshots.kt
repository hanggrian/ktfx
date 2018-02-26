@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.SnapshotParameters
import javafx.scene.image.WritableImage

inline fun Node.screenshot(
    params: SnapshotParameters? = null,
    image: WritableImage? = null
): WritableImage = snapshot(params, image)

inline fun Scene.screenshot(
    image: WritableImage? = null
): WritableImage = snapshot(image)