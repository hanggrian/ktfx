package kotlinfx.coroutines

import javafx.event.Event
import javafx.event.EventType
import javafx.scene.Scene
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
import kotlinfx.coroutines.internal.Interoperability.asCallback
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <E : Event> Scene.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventFilter(type) { event -> launch(context) { action(event) } }

fun <E : Event> Scene.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun Scene.onContextMenuRequested(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ContextMenuEvent) -> Unit
) = setOnContextMenuRequested { event -> launch(context) { action(event) } }

fun Scene.onDragDetected(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnDragDetected { event -> launch(context) { action(event) } }

fun Scene.onDragDone(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDone { event -> launch(context) { action(event) } }

fun Scene.onDragDropped(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDropped { event -> launch(context) { action(event) } }

fun Scene.onDragEntered(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragEntered { event -> launch(context) { action(event) } }

fun Scene.onDragExited(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragExited { event -> launch(context) { action(event) } }

fun Scene.onDragOver(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragOver { event -> launch(context) { action(event) } }

fun Scene.onInputMethodTextChanged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged { event -> launch(context) { action(event) } }

fun Scene.onKeyPressed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyPressed { event -> launch(context) { action(event) } }

fun Scene.onKeyReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyReleased { event -> launch(context) { action(event) } }

fun Scene.onKeyTyped(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyTyped { event -> launch(context) { action(event) } }

fun Scene.onMouseClicked(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseClicked { event -> launch(context) { action(event) } }

fun Scene.onMouseDragEntered(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragEntered { event -> launch(context) { action(event) } }

fun Scene.onMouseDragExited(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragExited { event -> launch(context) { action(event) } }

fun Scene.onMouseDragged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseDragged { event -> launch(context) { action(event) } }

fun Scene.onMouseDragOver(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragOver { event -> launch(context) { action(event) } }

fun Scene.onMouseDragReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragReleased { event -> launch(context) { action(event) } }

fun Scene.onMouseEntered(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseEntered { event -> launch(context) { action(event) } }

fun Scene.onMouseExited(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseExited { event -> launch(context) { action(event) } }

fun Scene.onMouseMoved(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseMoved { event -> launch(context) { action(event) } }

fun Scene.onMousePressed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMousePressed { event -> launch(context) { action(event) } }

fun Scene.onMouseReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseReleased { event -> launch(context) { action(event) } }

fun Scene.onRotate(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotate { event -> launch(context) { action(event) } }

fun Scene.onRotationFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationFinished { event -> launch(context) { action(event) } }

fun Scene.onRotationStarted(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationStarted { event -> launch(context) { action(event) } }

fun Scene.onScroll(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScroll { event -> launch(context) { action(event) } }

fun Scene.onScrollFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollFinished { event -> launch(context) { action(event) } }

fun Scene.onScrollStarted(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollStarted { event -> launch(context) { action(event) } }

fun Scene.onSwipeDown(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeDown { event -> launch(context) { action(event) } }

fun Scene.onSwipeLeft(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeLeft { event -> launch(context) { action(event) } }

fun Scene.onSwipeRight(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeRight { event -> launch(context) { action(event) } }

fun Scene.onSwipeUp(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeUp { event -> launch(context) { action(event) } }

fun Scene.onTouchMoved(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchMoved { event -> launch(context) { action(event) } }

fun Scene.setOnTouchPressed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchPressed { event -> launch(context) { action(event) } }

fun Scene.onTouchReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchReleased { event -> launch(context) { action(event) } }

fun Scene.onTouchStationary(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchStationary { event -> launch(context) { action(event) } }

fun Scene.onZoom(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoom { event -> launch(context) { action(event) } }

fun Scene.onZoomFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomFinished { event -> launch(context) { action(event) } }

fun Scene.onZoomStarted(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomStarted { event -> launch(context) { action(event) } }

fun Scene.screenshot(
    context: CoroutineContext = FX,
    image: WritableImage? = null,
    callback: suspend CoroutineScope.(SnapshotResult) -> Unit
) = snapshot(asCallback { param -> launch(context) { callback(param) } }, image)