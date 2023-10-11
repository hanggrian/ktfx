package ktfx.controls

import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.image.WritableImage

/** Alias of [Node.lookup] with non-null return and specified type. */
inline fun <reified T : Node> Node.find(selector: String): T = lookup(selector) as T

/** Take a snapshot of this [Node] returning image it wrote. */
inline fun Node.capture(
    image: WritableImage? = null,
    configuration: SnapshotParameters.() -> Unit = { }
): WritableImage = snapshot(SnapshotParameters().apply(configuration), image)
