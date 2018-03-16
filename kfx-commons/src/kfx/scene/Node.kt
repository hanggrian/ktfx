@file:Suppress("NOTHING_TO_INLINE")

package kfx.scene

import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.image.WritableImage

/** Take a screenshot of this [Node] returning image it wrote. */
@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
inline fun Node.snapshot(
    params: SnapshotParameters? = null,
    image: WritableImage? = null
): WritableImage = snapshot(params, image)