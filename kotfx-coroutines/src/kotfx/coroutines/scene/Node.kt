package kotfx.coroutines

import javafx.event.Event
import javafx.event.EventType
import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.SnapshotResult
import javafx.scene.image.WritableImage
import javafx.scene.input.ContextMenuEvent
import javafx.scene.input.DragEvent
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseDragEvent
import javafx.scene.input.MouseEvent
import javafx.scene.input.RotateEvent
import javafx.scene.input.ScrollEvent
import javafx.scene.input.SwipeEvent
import javafx.scene.input.TouchEvent
import javafx.scene.input.ZoomEvent
import kotfx.coroutines.internal.Interoperability.asCallback
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <E : Event> Node.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventFilter(type) { event -> launch(context) { action(event) } }

fun <E : Event> Node.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun Node.onContextMenuRequested(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ContextMenuEvent) -> Unit
) = setOnContextMenuRequested { event -> launch(context) { action(event) } }

fun Node.onDragDetected(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnDragDetected { event -> launch(context) { action(event) } }

fun Node.onDragDone(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDone { event -> launch(context) { action(event) } }

fun Node.onDragDropped(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDropped { event -> launch(context) { action(event) } }

fun Node.onDragEntered(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragEntered { event -> launch(context) { action(event) } }

fun Node.onDragExited(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragExited { event -> launch(context) { action(event) } }

fun Node.onDragOver(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragOver { event -> launch(context) { action(event) } }

fun Node.onInputMethodTextChanged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged { event -> launch(context) { action(event) } }

fun Node.onKeyPressed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyPressed { event -> launch(context) { action(event) } }

fun Node.onKeyReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyReleased { event -> launch(context) { action(event) } }

fun Node.onKeyTyped(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyTyped { event -> launch(context) { action(event) } }

fun Node.onMouseClicked(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseClicked { event -> launch(context) { action(event) } }

fun Node.onMouseDragEntered(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragEntered { event -> launch(context) { action(event) } }

fun Node.onMouseDragExited(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragExited { event -> launch(context) { action(event) } }

fun Node.onMouseDragged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseDragged { event -> launch(context) { action(event) } }

fun Node.onMouseDragOver(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragOver { event -> launch(context) { action(event) } }

fun Node.onMouseDragReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragReleased { event -> launch(context) { action(event) } }

fun Node.onMouseEntered(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseEntered { event -> launch(context) { action(event) } }

fun Node.onMouseExited(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseExited { event -> launch(context) { action(event) } }

fun Node.onMouseMoved(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseMoved { event -> launch(context) { action(event) } }

fun Node.onMousePressed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMousePressed { event -> launch(context) { action(event) } }

fun Node.onMouseReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseReleased { event -> launch(context) { action(event) } }

fun Node.onRotate(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotate { event -> launch(context) { action(event) } }

fun Node.onRotationFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationFinished { event -> launch(context) { action(event) } }

fun Node.onRotationStarted(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationStarted { event -> launch(context) { action(event) } }

fun Node.onScroll(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScroll { event -> launch(context) { action(event) } }

fun Node.onScrollFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollFinished { event -> launch(context) { action(event) } }

fun Node.onScrollStarted(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollStarted { event -> launch(context) { action(event) } }

fun Node.onSwipeDown(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeDown { event -> launch(context) { action(event) } }

fun Node.onSwipeLeft(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeLeft { event -> launch(context) { action(event) } }

fun Node.onSwipeRight(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeRight { event -> launch(context) { action(event) } }

fun Node.onSwipeUp(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeUp { event -> launch(context) { action(event) } }

fun Node.onTouchMoved(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchMoved { event -> launch(context) { action(event) } }

fun Node.setOnTouchPressed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchPressed { event -> launch(context) { action(event) } }

fun Node.onTouchReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchReleased { event -> launch(context) { action(event) } }

fun Node.onTouchStationary(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchStationary { event -> launch(context) { action(event) } }

fun Node.onZoom(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoom { event -> launch(context) { action(event) } }

fun Node.onZoomFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomFinished { event -> launch(context) { action(event) } }

fun Node.onZoomStarted(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomStarted { event -> launch(context) { action(event) } }

fun Node.screenshot(
    context: CoroutineContext = FX,
    params: SnapshotParameters? = null,
    image: WritableImage? = null,
    callback: suspend CoroutineScope.(SnapshotResult) -> Unit
) = snapshot(asCallback { param -> launch(context) { callback(param) } }, params, image)