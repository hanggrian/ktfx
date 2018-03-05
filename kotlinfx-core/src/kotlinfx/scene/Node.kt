@file:Suppress("NOTHING_TO_INLINE")

package kotlinfx.scene

import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.image.WritableImage

inline fun Node.screenshot(
    params: SnapshotParameters? = null,
    image: WritableImage? = null
): WritableImage = snapshot(params, image)