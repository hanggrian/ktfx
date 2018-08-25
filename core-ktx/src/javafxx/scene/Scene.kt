@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")

package javafxx.scene

import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.image.WritableImage

/** Alias of [Scene.lookup] with non-null return. */
inline operator fun Scene.get(selector: String): Node = checkNotNull(lookup(selector))

/** Alias of [Scene.lookup] with non-null return and specified type. */
@Suppress("UNCHECKED_CAST")
inline fun <T : Node> Scene.find(selector: String): T = checkNotNull(this[selector] as? T)

/** Take a screenshot of this [Scene] without writable image target. */
inline fun Scene.snapshot(image: WritableImage? = null): WritableImage = snapshot(image)