package javafxx.coroutines

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
import kotlinx.coroutines.experimental.launch
import javafxx.coroutines.internal.Callbacks.noReturn
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event filter to this node. */
fun <E : Event> Node.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> launch(context) { action(event) } }.also { addEventFilter(type, it) }

/** Registers an event handler to this node. */
fun <E : Event> Node.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> launch(context) { action(event) } }.also { addEventHandler(type, it) }

fun Node.onContextMenuRequested(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ContextMenuEvent) -> Unit
) = setOnContextMenuRequested { event -> launch(context) { action(event) } }

/** Defines a function to be called when drag gesture has been detected. */
fun Node.onDragDetected(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnDragDetected { event -> launch(context) { action(event) } }

/**
 * Defines a function to be called when this [Node] is a drag and drop gesture source after its data has been dropped on
 * a drop target.
 */
fun Node.onDragDone(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDone { event -> launch(context) { action(event) } }

/** Defines a function to be called when the mouse button is released on this [Node] during drag and drop gesture. */
fun Node.onDragDropped(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragDropped { event -> launch(context) { action(event) } }

/** Defines a function to be called when drag gesture enters this [Node]. */
fun Node.onDragEntered(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragEntered { event -> launch(context) { action(event) } }

/** Defines a function to be called when drag gesture exits this [Node]. */
fun Node.onDragExited(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragExited { event -> launch(context) { action(event) } }

/** Defines a function to be called when drag gesture progresses within this [Node]. */
fun Node.onDragOver(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DragEvent) -> Unit
) = setOnDragOver { event -> launch(context) { action(event) } }

/** Defines a function to be called when this [Node] has input focus and the input method text has changed. */
fun Node.onInputMethodTextChanged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged { event -> launch(context) { action(event) } }

/** Defines a function to be called when this [Node] or its child [Node] has input focus and a key has been pressed. */
fun Node.onKeyPressed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyPressed { event -> launch(context) { action(event) } }

/** Defines a function to be called when this [Node] or its child [Node] has input focus and a key has been released. */
fun Node.onKeyReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyReleased { event -> launch(context) { action(event) } }

/** Defines a function to be called when this [Node] or its child [Node] has input focus and a key has been typed. */
fun Node.onKeyTyped(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(KeyEvent) -> Unit
) = setOnKeyTyped { event -> launch(context) { action(event) } }

/** Defines a function to be called when a mouse button has been clicked (pressed and released) on this [Node]. */
fun Node.onMouseClicked(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseClicked { event -> launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture enters this [Node]. */
fun Node.onMouseDragEntered(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragEntered { event -> launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture leaves this [Node]. */
fun Node.onMouseDragExited(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragExited { event -> launch(context) { action(event) } }

/** Defines a function to be called when a mouse button is pressed on this [Node] and then dragged. */
fun Node.onMouseDragged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseDragged { event -> launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture progresses within this [Node]. */
fun Node.onMouseDragOver(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragOver { event -> launch(context) { action(event) } }

/** Defines a function to be called when a full press-drag-release gesture ends within this [Node]. */
fun Node.onMouseDragReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseDragEvent) -> Unit
) = setOnMouseDragReleased { event -> launch(context) { action(event) } }

/** Defines a function to be called when the mouse enters this [Node]. */
fun Node.onMouseEntered(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseEntered { event -> launch(context) { action(event) } }

/** Defines a function to be called when the mouse exits this [Node]. */
fun Node.onMouseExited(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseExited { event -> launch(context) { action(event) } }

/** Defines a function to be called when mouse cursor moves within this [Node] but no buttons have been pushed. */
fun Node.onMouseMoved(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseMoved { event -> launch(context) { action(event) } }

/** Defines a function to be called when a mouse button has been pressed on this [Node]. */
fun Node.onMousePressed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMousePressed { event -> launch(context) { action(event) } }

/** Defines a function to be called when a mouse button has been released on this [Node]. */
fun Node.onMouseReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MouseEvent) -> Unit
) = setOnMouseReleased { event -> launch(context) { action(event) } }

/** Defines a function to be called when user performs a rotation action. */
fun Node.onRotate(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotate { event -> launch(context) { action(event) } }

/** Defines a function to be called when a rotation gesture ends. */
fun Node.onRotationFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationFinished { event -> launch(context) { action(event) } }

/** Defines a function to be called when a rotation gesture is detected. */
fun Node.onRotationStarted(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(RotateEvent) -> Unit
) = setOnRotationStarted { event -> launch(context) { action(event) } }

/** Defines a function to be called when user performs a scrolling action. */
fun Node.onScroll(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScroll { event -> launch(context) { action(event) } }

/** Defines a function to be called when a scrolling gesture ends. */
fun Node.onScrollFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollFinished { event -> launch(context) { action(event) } }

/** Defines a function to be called when a scrolling gesture is detected. */
fun Node.onScrollStarted(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ScrollEvent) -> Unit
) = setOnScrollStarted { event -> launch(context) { action(event) } }

/** Defines a function to be called when a downward swipe gesture centered over this node happens. */
fun Node.onSwipeDown(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeDown { event -> launch(context) { action(event) } }

/** Defines a function to be called when a leftward swipe gesture centered over this node happens. */
fun Node.onSwipeLeft(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeLeft { event -> launch(context) { action(event) } }

/** Defines a function to be called when an rightward swipe gesture centered over this node happens. */
fun Node.onSwipeRight(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeRight { event -> launch(context) { action(event) } }

/** Defines a function to be called when an upward swipe gesture centered over this node happens. */
fun Node.onSwipeUp(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(SwipeEvent) -> Unit
) = setOnSwipeUp { event -> launch(context) { action(event) } }

/** Defines a function to be called when a touch point is moved. */
fun Node.onTouchMoved(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchMoved { event -> launch(context) { action(event) } }

/** Defines a function to be called when a new touch point is pressed. */
fun Node.setOnTouchPressed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchPressed { event -> launch(context) { action(event) } }

/** Defines a function to be called when a touch point is released. */
fun Node.onTouchReleased(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchReleased { event -> launch(context) { action(event) } }

/** Defines a function to be called when a touch point stays pressed and still. */
fun Node.onTouchStationary(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(TouchEvent) -> Unit
) = setOnTouchStationary { event -> launch(context) { action(event) } }

/** Defines a function to be called when user performs a zooming action. */
fun Node.onZoom(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoom { event -> launch(context) { action(event) } }

/** Defines a function to be called when a zooming gesture ends. */
fun Node.onZoomFinished(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomFinished { event -> launch(context) { action(event) } }

/** Defines a function to be called when a zooming gesture is detected. */
fun Node.onZoomStarted(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ZoomEvent) -> Unit
) = setOnZoomStarted { event -> launch(context) { action(event) } }

/** Takes a snapshot of this node at the next frame and calls the specified callback method when the image is ready. */
fun Node.snapshot(
    context: CoroutineContext = FX,
    params: SnapshotParameters? = null,
    image: WritableImage? = null,
    callback: suspend CoroutineScope.(SnapshotResult) -> Unit
) = snapshot(noReturn { param -> launch(context) { callback(param) } }, params, image)