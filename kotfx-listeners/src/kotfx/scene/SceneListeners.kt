@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene

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
import kotfx.internal.Interoperability.asCallback

inline fun <E : Event> Scene.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type, EventHandler(action))

inline fun <E : Event> Scene.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))

inline fun Scene.onContextMenuRequested(
    noinline action: (ContextMenuEvent) -> Unit
) = setOnContextMenuRequested(EventHandler(action))

inline fun Scene.onDragDetected(
    noinline action: (MouseEvent) -> Unit
) = setOnDragDetected(EventHandler(action))

inline fun Scene.onDragDone(
    noinline action: (DragEvent) -> Unit
) = setOnDragDone(EventHandler(action))

inline fun Scene.onDragDropped(
    noinline action: (DragEvent) -> Unit
) = setOnDragDropped(EventHandler(action))

inline fun Scene.onDragEntered(
    noinline action: (DragEvent) -> Unit
) = setOnDragEntered(EventHandler(action))

inline fun Scene.onDragExited(
    noinline action: (DragEvent) -> Unit
) = setOnDragExited(EventHandler(action))

inline fun Scene.onDragOver(
    noinline action: (DragEvent) -> Unit
) = setOnDragOver(EventHandler(action))

inline fun Scene.onInputMethodTextChanged(
    noinline action: (InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged(EventHandler(action))

inline fun Scene.onKeyPressed(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyPressed(EventHandler(action))

inline fun Scene.onKeyReleased(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyReleased(EventHandler(action))

inline fun Scene.onKeyTyped(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyTyped(EventHandler(action))

inline fun Scene.onMouseClicked(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseClicked(EventHandler(action))

inline fun Scene.onMouseDragEntered(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragEntered(EventHandler(action))

inline fun Scene.onMouseDragExited(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragExited(EventHandler(action))

inline fun Scene.onMouseDragged(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseDragged(EventHandler(action))

inline fun Scene.onMouseDragOver(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragOver(EventHandler(action))

inline fun Scene.onMouseDragReleased(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragReleased(EventHandler(action))

inline fun Scene.onMouseEntered(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseEntered(EventHandler(action))

inline fun Scene.onMouseExited(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseExited(EventHandler(action))

inline fun Scene.onMouseMoved(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseMoved(EventHandler(action))

inline fun Scene.onMousePressed(
    noinline action: (MouseEvent) -> Unit
) = setOnMousePressed(EventHandler(action))

inline fun Scene.onMouseReleased(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseReleased(EventHandler(action))

inline fun Scene.onRotate(
    noinline action: (RotateEvent) -> Unit
) = setOnRotate(EventHandler(action))

inline fun Scene.onRotationFinished(
    noinline action: (RotateEvent) -> Unit
) = setOnRotationFinished(EventHandler(action))

inline fun Scene.onRotationStarted(
    noinline action: (RotateEvent) -> Unit
) = setOnRotationStarted(EventHandler(action))

inline fun Scene.onScroll(
    noinline action: (ScrollEvent) -> Unit
) = setOnScroll(EventHandler(action))

inline fun Scene.onScrollFinished(
    noinline action: (ScrollEvent) -> Unit
) = setOnScrollFinished(EventHandler(action))

inline fun Scene.onScrollStarted(
    noinline action: (ScrollEvent) -> Unit
) = setOnScrollStarted(EventHandler(action))

inline fun Scene.onSwipeDown(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeDown(EventHandler(action))

inline fun Scene.onSwipeLeft(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeLeft(EventHandler(action))

inline fun Scene.onSwipeRight(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeRight(EventHandler(action))

inline fun Scene.onSwipeUp(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeUp(EventHandler(action))

inline fun Scene.onTouchMoved(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchMoved(EventHandler(action))

inline fun Scene.setOnTouchPressed(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchPressed(EventHandler(action))

inline fun Scene.onTouchReleased(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchReleased(EventHandler(action))

inline fun Scene.onTouchStationary(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchStationary(EventHandler(action))

inline fun Scene.onZoom(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoom(EventHandler(action))

inline fun Scene.onZoomFinished(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoomFinished(EventHandler(action))

inline fun Scene.onZoomStarted(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoomStarted(EventHandler(action))

inline fun Scene.screenshot(
    image: WritableImage? = null,
    noinline callback: (SnapshotResult) -> Unit
) = snapshot(asCallback(callback), image)