package ktfx.controls

import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.image.WritableImage

/** Alias of [Scene.lookup] with non-null return and specified type. */
inline fun <reified T : Node> Scene.find(selector: String): T = lookup(selector) as T

/** Take a snapshot of this [Node] returning image it wrote. */
@Suppress("NOTHING_TO_INLINE")
inline fun Scene.snapshot(): WritableImage = snapshot(null)
