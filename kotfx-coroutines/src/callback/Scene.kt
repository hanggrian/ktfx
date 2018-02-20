@file:JvmMultifileClass
@file:JvmName("CallbacksKt")

package kotfx.coroutines

import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.SnapshotParameters
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun Node.snapshot(
    context: CoroutineContext = JavaFx,
    params: SnapshotParameters,
    image: WritableImage,
    action: suspend CoroutineScope.(SnapshotResult) -> Void
) = snapshot({ param -> runBlocking(context) { action(param) } }, params, image)

fun Scene.snapshot(
    context: CoroutineContext = JavaFx,
    image: WritableImage,
    action: suspend CoroutineScope.(SnapshotResult) -> Void
) = snapshot({ param -> runBlocking(context) { action(param) } }, image)