@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.Event
import javafx.event.EventHandler
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
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event filter to this scene. */
fun <E : Event> Scene.eventFilter(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventFilter(type, it) }

/** Registers an event handler to this scene. */
fun <E : Event> Scene.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventHandler(type, it) }

fun Scene.onContextMenuRequested(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ContextMenuEvent) -> Unit
) = setOnContextMenuRequested { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when drag gesture has been detected. */
fun Scene.onDragDetected(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnDragDetected { event -> GlobalScope.launch(context) { action(event) } }

/**
 * Defines a function to be called when this [Scene] is a drag and drop gesture source after its data has been dropped
 * on a drop target.
 */
fun Scene.onDragDone(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDone { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when the mouse button is released on this [Scene] during drag and drop gesture. */
fun Scene.onDragDropped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDropped { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when drag gesture enters this [Scene]. */
fun Scene.onDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragEntered { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when drag gesture exits this [Scene]. */
fun Scene.onDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragExited { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when drag gesture progresses within this [Scene]. */
fun Scene.onDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragOver { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when this [Node] has input focus and the input method text has changed. */
fun Scene.onInputMethodTextChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when some [Node] of this [Scene] has input focus and a key has been pressed. */
fun Scene.onKeyPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyPressed { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when some [Node] of this [Scene] has input focus and a key has been released. */
fun Scene.onKeyReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyReleased { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when some [Node] of this [Scene] has input focus and a key has been typed. */
fun Scene.onKeyTyped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyTyped { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a mouse button has been clicked (pressed and released) on this [Scene]. */
fun Scene.onMouseClicked(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseClicked { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture enters this [Scene]. */
fun Scene.onMouseDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragEntered { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture exits this [Scene]. */
fun Scene.onMouseDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragExited { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a mouse button is pressed on this [Scene] and then dragged. */
fun Scene.onMouseDragged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseDragged { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture progresses within this [Scene]. */
fun Scene.onMouseDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragOver { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture ends within this [Scene]. */
fun Scene.onMouseDragReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragReleased { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when the mouse enters this [Scene]. */
fun Scene.onMouseEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseEntered { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when the mouse exits this [Scene]. */
fun Scene.onMouseExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseExited { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when mouse cursor moves within this [Scene] but no buttons have been pushed. */
fun Scene.onMouseMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseMoved { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a mouse button has been pressed on this [Scene]. */
fun Scene.onMousePressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMousePressed { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a mouse button has been released on this [Scene]. */
fun Scene.onMouseReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseReleased { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when user performs a rotating action. */
fun Scene.onRotate(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotate { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a rotating gesture ends. */
fun Scene.onRotationFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationFinished { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a rotating gesture is detected. */
fun Scene.onRotationStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationStarted { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when user performs a scrolling action. */
fun Scene.onScroll(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScroll { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a scrolling gesture ends. */
fun Scene.onScrollFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollFinished { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a scrolling gesture is detected. */
fun Scene.onScrollStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollStarted { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when an downward swipe gesture happens in this scene. */
fun Scene.onSwipeDown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeDown { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when an leftward swipe gesture happens in this scene. */
fun Scene.onSwipeLeft(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeLeft { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when an rightward swipe gesture happens in this scene. */
fun Scene.onSwipeRight(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeRight { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when an upward swipe gesture happens in this scene. */
fun Scene.onSwipeUp(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeUp { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a touch point is moved. */
fun Scene.onTouchMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchMoved { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a new touch point is pressed. */
fun Scene.setOnTouchPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchPressed { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a new touch point is pressed. */
fun Scene.onTouchReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchReleased { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a touch point stays pressed and still. */
fun Scene.onTouchStationary(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchStationary { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when user performs a zooming action. */
fun Scene.onZoom(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoom { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a zooming gesture ends. */
fun Scene.onZoomFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomFinished { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a zooming gesture is detected. */
fun Scene.onZoomStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomStarted { event -> GlobalScope.launch(context) { action(event) } }

/** Takes a snapshot of this scene at the next frame and calls the specified callback method when the image is ready. */
fun Scene.snapshot(
    context: CoroutineContext = Dispatchers.JavaFx,
    image: WritableImage? = null,
    callback: suspend CoroutineScope.(SnapshotResult) -> Unit
) = snapshot(Callbacks.noReturn { param -> GlobalScope.launch(context) { callback(param) } }, image)