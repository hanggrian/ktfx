@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.Event
import javafx.event.EventHandler
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
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event filter to this node. */
fun <E : Event> Node.eventFilter(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventFilter(type, it) }

/** Registers an event handler to this node. */
fun <E : Event> Node.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventHandler(type, it) }

fun Node.onContextMenuRequested(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ContextMenuEvent) -> Unit
) = setOnContextMenuRequested { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when drag gesture has been detected. */
fun Node.onDragDetected(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnDragDetected { event -> GlobalScope.launch(context) { action(event) } }

/**
 * Defines a function to be called when this [Node] is a drag and drop gesture source after its data has been dropped on
 * a drop target.
 */
fun Node.onDragDone(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDone { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when the mouse button is released on this [Node] during drag and drop gesture. */
fun Node.onDragDropped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDropped { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when drag gesture enters this [Node]. */
fun Node.onDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragEntered { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when drag gesture exits this [Node]. */
fun Node.onDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragExited { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when drag gesture progresses within this [Node]. */
fun Node.onDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragOver { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when this [Node] has input focus and the input method text has changed. */
fun Node.onInputMethodTextChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when this [Node] or its child [Node] has input focus and a key has been pressed. */
fun Node.onKeyPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyPressed { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when this [Node] or its child [Node] has input focus and a key has been released. */
fun Node.onKeyReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyReleased { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when this [Node] or its child [Node] has input focus and a key has been typed. */
fun Node.onKeyTyped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyTyped { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a mouse button has been clicked (pressed and released) on this [Node]. */
fun Node.onMouseClicked(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseClicked { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture enters this [Node]. */
fun Node.onMouseDragEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragEntered { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture leaves this [Node]. */
fun Node.onMouseDragExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragExited { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a mouse button is pressed on this [Node] and then dragged. */
fun Node.onMouseDragged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseDragged { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture progresses within this [Node]. */
fun Node.onMouseDragOver(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragOver { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture ends within this [Node]. */
fun Node.onMouseDragReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragReleased { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when the mouse enters this [Node]. */
fun Node.onMouseEntered(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseEntered { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when the mouse exits this [Node]. */
fun Node.onMouseExited(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseExited { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when mouse cursor moves within this [Node] but no buttons have been pushed. */
fun Node.onMouseMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseMoved { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a mouse button has been pressed on this [Node]. */
fun Node.onMousePressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMousePressed { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a mouse button has been released on this [Node]. */
fun Node.onMouseReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseReleased { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when user performs a rotation action. */
fun Node.onRotate(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotate { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a rotation gesture ends. */
fun Node.onRotationFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationFinished { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a rotation gesture is detected. */
fun Node.onRotationStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationStarted { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when user performs a scrolling action. */
fun Node.onScroll(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScroll { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a scrolling gesture ends. */
fun Node.onScrollFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollFinished { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a scrolling gesture is detected. */
fun Node.onScrollStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollStarted { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a downward swipe gesture centered over this node happens. */
fun Node.onSwipeDown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeDown { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a leftward swipe gesture centered over this node happens. */
fun Node.onSwipeLeft(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeLeft { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when an rightward swipe gesture centered over this node happens. */
fun Node.onSwipeRight(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeRight { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when an upward swipe gesture centered over this node happens. */
fun Node.onSwipeUp(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeUp { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a touch point is moved. */
fun Node.onTouchMoved(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchMoved { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a new touch point is pressed. */
fun Node.setOnTouchPressed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchPressed { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a touch point is released. */
fun Node.onTouchReleased(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchReleased { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a touch point stays pressed and still. */
fun Node.onTouchStationary(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchStationary { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when user performs a zooming action. */
fun Node.onZoom(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoom { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a zooming gesture ends. */
fun Node.onZoomFinished(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomFinished { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a zooming gesture is detected. */
fun Node.onZoomStarted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomStarted { event -> GlobalScope.launch(context) { action(event) } }

/** Takes a snapshot of this node at the next frame and calls the specified callback method when the image is ready. */
fun Node.snapshot(
    context: CoroutineContext = Dispatchers.JavaFx,
    params: SnapshotParameters? = null,
    image: WritableImage? = null,
    callback: suspend CoroutineScope.(SnapshotResult) -> Unit
) = snapshot(Callbacks.noReturn { param -> GlobalScope.launch(context) { callback(param) } }, params, image)