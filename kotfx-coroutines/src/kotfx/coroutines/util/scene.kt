@file:JvmMultifileClass
@file:JvmName("UtilsKt")

package kotfx.coroutines

import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.SnapshotParameters
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun Node.snapshot(
    context: CoroutineContext = FX,
    params: SnapshotParameters,
    image: WritableImage,
    callback: suspend CoroutineScope.(SnapshotResult) -> Void
) = snapshot({ param -> runBlocking(context) { callback(param) } }, params, image)

fun Scene.snapshot(
    context: CoroutineContext = FX,
    image: WritableImage,
    callback: suspend CoroutineScope.(SnapshotResult) -> Void
) = snapshot({ param -> runBlocking(context) { callback(param) } }, image)