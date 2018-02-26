@file:JvmName("ScenesKt")

package kotfx.coroutines

import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.SnapshotParameters
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage
import kotfx.internal.Interops
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun Node.screenshot(
    context: CoroutineContext = FX,
    params: SnapshotParameters? = null,
    image: WritableImage? = null,
    callback: suspend CoroutineScope.(SnapshotResult) -> Unit
) = snapshot(Interops.asCallback { param -> launch(context) { callback(param) } }, params, image)

fun Scene.screenshot(
    context: CoroutineContext = FX,
    image: WritableImage? = null,
    callback: suspend CoroutineScope.(SnapshotResult) -> Unit
) = snapshot(Interops.asCallback { param -> launch(context) { callback(param) } }, image)