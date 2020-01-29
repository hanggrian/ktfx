@file:JvmMultifileClass
@file:JvmName("NodeKt")

package ktfx.controls

import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage
import ktfx.internal.KtfxInternals

/** Alias of [Node.lookup] with non-null return and specified type. */
inline fun <reified T : Node> Node.find(selector: String): T = lookup(selector) as T

/** Take a snapshot of this [Node] returning image it wrote. */
inline fun Node.snapshot(
    image: WritableImage? = null,
    configuration: SnapshotParameters.() -> Unit
): WritableImage = snapshot(SnapshotParameters().apply(configuration), image)

/** Take a snapshot of this [Node] using callback. */
inline fun Node.snapshot(
    image: WritableImage? = null,
    configuration: SnapshotParameters.() -> Unit,
    crossinline callback: (SnapshotResult) -> Unit
): Unit = snapshot(KtfxInternals.noReturn(callback), SnapshotParameters().apply(configuration), image)
