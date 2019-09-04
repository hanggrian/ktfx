@file:JvmMultifileClass
@file:JvmName("NodesKt")
@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")

package ktfx.controls

import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.image.WritableImage
import javafx.scene.layout.Pane
import ktfx.internal.KtfxInternals

/** Alias of [Node.lookup] with non-null return and specified type. */
@Suppress("UNCHECKED_CAST")
inline fun <T : Node> Node.find(selector: String): T =
    lookup(selector) as T

/** Take a screenshot of this [Node] returning image it wrote. */
inline fun Node.snapshot(
    params: SnapshotParameters? = null,
    image: WritableImage? = null
): WritableImage = snapshot(params, image)

/** Wraps this child in pane, if not already. */
fun Node.asPane(): Pane =
    KtfxInternals.asPane(this)
