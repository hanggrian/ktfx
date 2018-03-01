@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene

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
import kotfx.internal.Interoperability.asCallback

inline fun <E : Event> Node.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type, EventHandler(action))

inline fun <E : Event> Node.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))

inline fun Node.onContextMenuRequested(
    noinline action: (ContextMenuEvent) -> Unit
) = setOnContextMenuRequested(EventHandler(action))

inline fun Node.onDragDetected(
    noinline action: (MouseEvent) -> Unit
) = setOnDragDetected(EventHandler(action))

inline fun Node.onDragDone(
    noinline action: (DragEvent) -> Unit
) = setOnDragDone(EventHandler(action))

inline fun Node.onDragDropped(
    noinline action: (DragEvent) -> Unit
) = setOnDragDropped(EventHandler(action))

inline fun Node.onDragEntered(
    noinline action: (DragEvent) -> Unit
) = setOnDragEntered(EventHandler(action))

inline fun Node.onDragExited(
    noinline action: (DragEvent) -> Unit
) = setOnDragExited(EventHandler(action))

inline fun Node.onDragOver(
    noinline action: (DragEvent) -> Unit
) = setOnDragOver(EventHandler(action))

inline fun Node.onInputMethodTextChanged(
    noinline action: (InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged(EventHandler(action))

inline fun Node.onKeyPressed(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyPressed(EventHandler(action))

inline fun Node.onKeyReleased(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyReleased(EventHandler(action))

inline fun Node.onKeyTyped(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyTyped(EventHandler(action))

inline fun Node.onMouseClicked(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseClicked(EventHandler(action))

inline fun Node.onMouseDragEntered(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragEntered(EventHandler(action))

inline fun Node.onMouseDragExited(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragExited(EventHandler(action))

inline fun Node.onMouseDragged(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseDragged(EventHandler(action))

inline fun Node.onMouseDragOver(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragOver(EventHandler(action))

inline fun Node.onMouseDragReleased(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragReleased(EventHandler(action))

inline fun Node.onMouseEntered(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseEntered(EventHandler(action))

inline fun Node.onMouseExited(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseExited(EventHandler(action))

inline fun Node.onMouseMoved(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseMoved(EventHandler(action))

inline fun Node.onMousePressed(
    noinline action: (MouseEvent) -> Unit
) = setOnMousePressed(EventHandler(action))

inline fun Node.onMouseReleased(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseReleased(EventHandler(action))

inline fun Node.onRotate(
    noinline action: (RotateEvent) -> Unit
) = setOnRotate(EventHandler(action))

inline fun Node.onRotationFinished(
    noinline action: (RotateEvent) -> Unit
) = setOnRotationFinished(EventHandler(action))

inline fun Node.onRotationStarted(
    noinline action: (RotateEvent) -> Unit
) = setOnRotationStarted(EventHandler(action))

inline fun Node.onScroll(
    noinline action: (ScrollEvent) -> Unit
) = setOnScroll(EventHandler(action))

inline fun Node.onScrollFinished(
    noinline action: (ScrollEvent) -> Unit
) = setOnScrollFinished(EventHandler(action))

inline fun Node.onScrollStarted(
    noinline action: (ScrollEvent) -> Unit
) = setOnScrollStarted(EventHandler(action))

inline fun Node.onSwipeDown(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeDown(EventHandler(action))

inline fun Node.onSwipeLeft(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeLeft(EventHandler(action))

inline fun Node.onSwipeRight(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeRight(EventHandler(action))

inline fun Node.onSwipeUp(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeUp(EventHandler(action))

inline fun Node.onTouchMoved(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchMoved(EventHandler(action))

inline fun Node.setOnTouchPressed(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchPressed(EventHandler(action))

inline fun Node.onTouchReleased(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchReleased(EventHandler(action))

inline fun Node.onTouchStationary(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchStationary(EventHandler(action))

inline fun Node.onZoom(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoom(EventHandler(action))

inline fun Node.onZoomFinished(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoomFinished(EventHandler(action))

inline fun Node.onZoomStarted(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoomStarted(EventHandler(action))

inline fun Node.screenshot(
    params: SnapshotParameters? = null,
    image: WritableImage? = null,
    noinline callback: (SnapshotResult) -> Unit
) = snapshot(asCallback(callback), params, image)