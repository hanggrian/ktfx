@file:JvmMultifileClass
@file:JvmName("EventsKt")

package kotfx.coroutines

import javafx.event.Event
import javafx.event.EventType
import javafx.scene.Node
import javafx.scene.Scene
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
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <E : Event> Node.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    consume: Boolean = false,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventFilter(type) { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun <E : Event> Node.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    consume: Boolean = false,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onContextMenuRequested(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ContextMenuEvent) -> Unit
) = setOnContextMenuRequested { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onDragDetected(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnDragDetected { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onDragDone(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDone { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onDragDropped(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDropped { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onDragEntered(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragEntered { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onDragExited(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragExited { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onDragOver(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragOver { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onInputMethodTextChanged(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onKeyPressed(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyPressed { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onKeyReleased(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyReleased { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onKeyTyped(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyTyped { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseClicked(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseClicked { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseDragEntered(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragEntered { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseDragExited(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragExited { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseDragged(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseDragged { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseDragOver(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragOver { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseDragReleased(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragReleased { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseEntered(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseEntered { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseExited(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseExited { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseMoved(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseMoved { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMousePressed(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMousePressed { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onMouseReleased(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseReleased { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onRotate(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotate { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onRotationFinished(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationFinished { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onRotationStarted(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationStarted { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onScroll(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScroll { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onScrollFinished(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollFinished { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onScrollStarted(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollStarted { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onSwipeDown(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeDown { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onSwipeLeft(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeLeft { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onSwipeRight(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeRight { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onSwipeUp(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeUp { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onTouchMoved(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchMoved { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.setOnTouchPressed(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchPressed { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onTouchReleased(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchReleased { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onTouchStationary(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchStationary { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onZoom(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoom { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onZoomFinished(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomFinished { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Node.onZoomStarted(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomStarted { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun <E : Event> Scene.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    consume: Boolean = false,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventFilter(type) { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun <E : Event> Scene.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    consume: Boolean = false,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onContextMenuRequested(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ContextMenuEvent) -> Unit
) = setOnContextMenuRequested { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onDragDetected(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnDragDetected { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onDragDone(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDone { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onDragDropped(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDropped { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onDragEntered(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragEntered { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onDragExited(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragExited { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onDragOver(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragOver { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onInputMethodTextChanged(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onKeyPressed(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyPressed { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onKeyReleased(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyReleased { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onKeyTyped(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyTyped { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseClicked(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseClicked { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseDragEntered(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragEntered { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseDragExited(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragExited { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseDragged(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseDragged { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseDragOver(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragOver { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseDragReleased(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragReleased { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseEntered(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseEntered { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseExited(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseExited { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseMoved(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseMoved { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMousePressed(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMousePressed { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onMouseReleased(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseReleased { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onRotate(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotate { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onRotationFinished(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationFinished { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onRotationStarted(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationStarted { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onScroll(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScroll { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onScrollFinished(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollFinished { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onScrollStarted(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollStarted { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onSwipeDown(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeDown { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onSwipeLeft(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeLeft { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onSwipeRight(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeRight { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onSwipeUp(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeUp { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onTouchMoved(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchMoved { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.setOnTouchPressed(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchPressed { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onTouchReleased(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchReleased { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onTouchStationary(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchStationary { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onZoom(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoom { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onZoomFinished(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomFinished { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Scene.onZoomStarted(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomStarted { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}