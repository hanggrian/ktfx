package ktfx.controls

import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage
import ktfx.internal.KtfxInternals

/** Alias of [Scene.lookup] with non-null return and specified type. */
inline fun <reified T : Node> Scene.find(selector: String): T = lookup(selector) as T

/** Take a snapshot of this [Node] returning image it wrote. */
@Suppress("NOTHING_TO_INLINE")
inline fun Scene.snapshot(): WritableImage = snapshot(null)

/** Take a snapshot of this [Node] using callback. */
inline fun Scene.snapshot(
    image: WritableImage? = null,
    crossinline callback: (SnapshotResult) -> Unit
): Unit = snapshot(KtfxInternals.noReturn(callback), image)
