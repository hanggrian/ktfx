@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

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
import ktfx.internal.KtfxInternals

/** Registers an event filter to this scene. */
inline fun <E : Event> Scene.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventFilter(type, it) }

/** Registers an event handler to this scene. */
inline fun <E : Event> Scene.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventHandler(type, it) }

/** Defines a function to be called when a mouse button has been clicked (pressed and released) on this [Scene]. */
inline fun Scene.onMouseClicked(
    noinline action: (MouseEvent) -> Unit
): Unit = setOnMouseClicked(action)

/** Defines a function to be called when a mouse button is pressed on this [Scene] and then dragged. */
inline fun Scene.onMouseDragged(
    noinline action: (MouseEvent) -> Unit
): Unit = setOnMouseDragged(action)

/** Defines a function to be called when the mouse enters this [Scene]. */
inline fun Scene.onMouseEntered(
    noinline action: (MouseEvent) -> Unit
): Unit = setOnMouseEntered(action)

/** Defines a function to be called when the mouse exits this [Scene]. */
inline fun Scene.onMouseExited(
    noinline action: (MouseEvent) -> Unit
): Unit = setOnMouseExited(action)

/** Defines a function to be called when mouse cursor moves within this [Scene] but no buttons have been pushed. */
inline fun Scene.onMouseMoved(
    noinline action: (MouseEvent) -> Unit
): Unit = setOnMouseMoved(action)

/** Defines a function to be called when a mouse button has been pressed on this [Scene]. */
inline fun Scene.onMousePressed(
    noinline action: (MouseEvent) -> Unit
): Unit = setOnMousePressed(action)

/** Defines a function to be called when a mouse button has been released on this [Scene]. */
inline fun Scene.onMouseReleased(
    noinline action: (MouseEvent) -> Unit
): Unit = setOnMouseReleased(action)

/** Defines a function to be called when drag gesture has been detected. */
inline fun Scene.onDragDetected(
    noinline action: (MouseEvent) -> Unit
): Unit = setOnDragDetected(action)

/** Defines a function to be called when a full press-drag-release gesture progresses within this [Scene]. */
inline fun Scene.onMouseDragOver(
    noinline action: (MouseDragEvent) -> Unit
): Unit = setOnMouseDragOver(action)

/** Defines a function to be called when a full press-drag-release gesture ends within this [Scene]. */
inline fun Scene.onMouseDragReleased(
    noinline action: (MouseDragEvent) -> Unit
): Unit = setOnMouseDragReleased(action)

/** Defines a function to be called when a full press-drag-release gesture enters this [Scene]. */
inline fun Scene.onMouseDragEntered(
    noinline action: (MouseDragEvent) -> Unit
): Unit = setOnMouseDragEntered(action)

/** Defines a function to be called when a full press-drag-release gesture exits this [Scene]. */
inline fun Scene.onMouseDragExited(
    noinline action: (MouseDragEvent) -> Unit
): Unit = setOnMouseDragExited(action)

/** Defines a function to be called when a scrolling gesture is detected. */
inline fun Scene.onScrollStarted(
    noinline action: (ScrollEvent) -> Unit
): Unit = setOnScrollStarted(action)

/** Defines a function to be called when user performs a scrolling action. */
inline fun Scene.onScroll(
    noinline action: (ScrollEvent) -> Unit
): Unit = setOnScroll(action)

/** Defines a function to be called when a scrolling gesture ends. */
inline fun Scene.onScrollFinished(
    noinline action: (ScrollEvent) -> Unit
): Unit = setOnScrollFinished(action)

/** Defines a function to be called when a rotating gesture is detected. */
inline fun Scene.onRotateStarted(
    noinline action: (RotateEvent) -> Unit
): Unit = setOnRotationStarted(action)

/** Defines a function to be called when user performs a rotating action. */
inline fun Scene.onRotate(
    noinline action: (RotateEvent) -> Unit
): Unit = setOnRotate(action)

/** Defines a function to be called when a rotating gesture ends. */
inline fun Scene.onRotateFinished(
    noinline action: (RotateEvent) -> Unit
): Unit = setOnRotationFinished(action)

/** Defines a function to be called when a zooming gesture is detected. */
inline fun Scene.onZoomStarted(
    noinline action: (ZoomEvent) -> Unit
): Unit = setOnZoomStarted(action)

/** Defines a function to be called when user performs a zooming action. */
inline fun Scene.onZoom(
    noinline action: (ZoomEvent) -> Unit
): Unit = setOnZoom(action)

/** Defines a function to be called when a zooming gesture ends. */
inline fun Scene.onZoomFinished(
    noinline action: (ZoomEvent) -> Unit
): Unit = setOnZoomFinished(action)

/** Defines a function to be called when an upward swipe gesture happens in this scene. */
inline fun Scene.onSwipeUp(
    noinline action: (SwipeEvent) -> Unit
): Unit = setOnSwipeUp(action)

/** Defines a function to be called when an downward swipe gesture happens in this scene. */
inline fun Scene.onSwipeDown(
    noinline action: (SwipeEvent) -> Unit
): Unit = setOnSwipeDown(action)

/** Defines a function to be called when an leftward swipe gesture happens in this scene. */
inline fun Scene.onSwipeLeft(
    noinline action: (SwipeEvent) -> Unit
): Unit = setOnSwipeLeft(action)

/** Defines a function to be called when an rightward swipe gesture happens in this scene. */
inline fun Scene.onSwipeRight(
    noinline action: (SwipeEvent) -> Unit
): Unit = setOnSwipeRight(action)

/** Defines a function to be called when a new touch point is pressed. */
inline fun Scene.onTouchPressed(
    noinline action: (TouchEvent) -> Unit
): Unit = setOnTouchPressed(action)

/** Defines a function to be called when a touch point is moved. */
inline fun Scene.onTouchMoved(
    noinline action: (TouchEvent) -> Unit
): Unit = setOnTouchMoved(action)

/** Defines a function to be called when a new touch point is pressed. */
inline fun Scene.onTouchReleased(
    noinline action: (TouchEvent) -> Unit
): Unit = setOnTouchReleased(action)

/** Defines a function to be called when a touch point stays pressed and still. */
inline fun Scene.onTouchStationary(
    noinline action: (TouchEvent) -> Unit
): Unit = setOnTouchStationary(action)

/** Defines a function to be called when drag gesture enters this [Scene]. */
inline fun Scene.onDragEntered(
    noinline action: (DragEvent) -> Unit
): Unit = setOnDragEntered(action)

/** Defines a function to be called when drag gesture exits this [Scene]. */
inline fun Scene.onDragExited(
    noinline action: (DragEvent) -> Unit
): Unit = setOnDragExited(action)

/** Defines a function to be called when drag gesture progresses within this [Scene]. */
inline fun Scene.onDragOver(
    noinline action: (DragEvent) -> Unit
): Unit = setOnDragOver(action)

/** Defines a function to be called when the mouse button is released on this [Scene] during drag and drop gesture. */
inline fun Scene.onDragDropped(
    noinline action: (DragEvent) -> Unit
): Unit = setOnDragDropped(action)

/**
 * Defines a function to be called when this [Scene] is a drag and drop gesture source after its data has been dropped
 * on a drop target.
 */
inline fun Scene.onDragDone(
    noinline action: (DragEvent) -> Unit
): Unit = setOnDragDone(action)

/** Defines a function to be called when some [Node] of this [Scene] has input focus and a key has been pressed. */
inline fun Scene.onKeyPressed(
    noinline action: (KeyEvent) -> Unit
): Unit = setOnKeyPressed(action)

/** Defines a function to be called when some [Node] of this [Scene] has input focus and a key has been released. */
inline fun Scene.onKeyReleased(
    noinline action: (KeyEvent) -> Unit
): Unit = setOnKeyReleased(action)

/** Defines a function to be called when some [Node] of this [Scene] has input focus and a key has been typed. */
inline fun Scene.onKeyTyped(
    noinline action: (KeyEvent) -> Unit
): Unit = setOnKeyTyped(action)

/** Defines a function to be called when this [Node] has input focus and the input method text has changed. */
inline fun Scene.onInputMethodTextChanged(
    noinline action: (InputMethodEvent) -> Unit
): Unit = setOnInputMethodTextChanged(action)

inline fun Scene.onContextMenuRequested(
    noinline action: (ContextMenuEvent) -> Unit
): Unit = setOnContextMenuRequested(action)

/** Takes a snapshot of this scene at the next frame and calls the specified callback method when the image is ready. */
inline fun Scene.snapshot(
    image: WritableImage? = null,
    noinline callback: (SnapshotResult) -> Unit
): Unit = snapshot(KtfxInternals.noReturn { param -> callback(param) }, image)
