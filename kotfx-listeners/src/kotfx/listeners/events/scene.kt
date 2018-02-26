@file:JvmMultifileClass
@file:JvmName("EventsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

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

inline fun <E : Event> Node.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type) { event -> action(event) }

inline fun <E : Event> Node.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type) { event -> action(event) }

inline fun Node.onContextMenuRequested(
    noinline action: (ContextMenuEvent) -> Unit
) = setOnContextMenuRequested { event -> action(event) }

inline fun Node.onDragDetected(
    noinline action: (MouseEvent) -> Unit
) = setOnDragDetected { event -> action(event) }

inline fun Node.onDragDone(
    noinline action: (DragEvent) -> Unit
) = setOnDragDone { event -> action(event) }

inline fun Node.onDragDropped(
    noinline action: (DragEvent) -> Unit
) = setOnDragDropped { event -> action(event) }

inline fun Node.onDragEntered(
    noinline action: (DragEvent) -> Unit
) = setOnDragEntered { event -> action(event) }

inline fun Node.onDragExited(
    noinline action: (DragEvent) -> Unit
) = setOnDragExited { event -> action(event) }

inline fun Node.onDragOver(
    noinline action: (DragEvent) -> Unit
) = setOnDragOver { event -> action(event) }

inline fun Node.onInputMethodTextChanged(
    noinline action: (InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged { event -> action(event) }

inline fun Node.onKeyPressed(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyPressed { event -> action(event) }

inline fun Node.onKeyReleased(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyReleased { event -> action(event) }

inline fun Node.onKeyTyped(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyTyped { event -> action(event) }

inline fun Node.onMouseClicked(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseClicked { event -> action(event) }

inline fun Node.onMouseDragEntered(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragEntered { event -> action(event) }

inline fun Node.onMouseDragExited(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragExited { event -> action(event) }

inline fun Node.onMouseDragged(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseDragged { event -> action(event) }

inline fun Node.onMouseDragOver(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragOver { event -> action(event) }

inline fun Node.onMouseDragReleased(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragReleased { event -> action(event) }

inline fun Node.onMouseEntered(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseEntered { event -> action(event) }

inline fun Node.onMouseExited(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseExited { event -> action(event) }

inline fun Node.onMouseMoved(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseMoved { event -> action(event) }

inline fun Node.onMousePressed(
    noinline action: (MouseEvent) -> Unit
) = setOnMousePressed { event -> action(event) }

inline fun Node.onMouseReleased(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseReleased { event -> action(event) }

inline fun Node.onRotate(
    noinline action: (RotateEvent) -> Unit
) = setOnRotate { event -> action(event) }

inline fun Node.onRotationFinished(
    noinline action: (RotateEvent) -> Unit
) = setOnRotationFinished { event -> action(event) }

inline fun Node.onRotationStarted(
    noinline action: (RotateEvent) -> Unit
) = setOnRotationStarted { event -> action(event) }

inline fun Node.onScroll(
    noinline action: (ScrollEvent) -> Unit
) = setOnScroll { event -> action(event) }

inline fun Node.onScrollFinished(
    noinline action: (ScrollEvent) -> Unit
) = setOnScrollFinished { event -> action(event) }

inline fun Node.onScrollStarted(
    noinline action: (ScrollEvent) -> Unit
) = setOnScrollStarted { event -> action(event) }

inline fun Node.onSwipeDown(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeDown { event -> action(event) }

inline fun Node.onSwipeLeft(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeLeft { event -> action(event) }

inline fun Node.onSwipeRight(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeRight { event -> action(event) }

inline fun Node.onSwipeUp(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeUp { event -> action(event) }

inline fun Node.onTouchMoved(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchMoved { event -> action(event) }

inline fun Node.setOnTouchPressed(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchPressed { event -> action(event) }

inline fun Node.onTouchReleased(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchReleased { event -> action(event) }

inline fun Node.onTouchStationary(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchStationary { event -> action(event) }

inline fun Node.onZoom(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoom { event -> action(event) }

inline fun Node.onZoomFinished(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoomFinished { event -> action(event) }

inline fun Node.onZoomStarted(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoomStarted { event -> action(event) }

inline fun <E : Event> Scene.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type) { event -> action(event) }

inline fun <E : Event> Scene.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type) { event -> action(event) }

inline fun Scene.onContextMenuRequested(
    noinline action: (ContextMenuEvent) -> Unit
) = setOnContextMenuRequested { event -> action(event) }

inline fun Scene.onDragDetected(
    noinline action: (MouseEvent) -> Unit
) = setOnDragDetected { event -> action(event) }

inline fun Scene.onDragDone(
    noinline action: (DragEvent) -> Unit
) = setOnDragDone { event -> action(event) }

inline fun Scene.onDragDropped(
    noinline action: (DragEvent) -> Unit
) = setOnDragDropped { event -> action(event) }

inline fun Scene.onDragEntered(
    noinline action: (DragEvent) -> Unit
) = setOnDragEntered { event -> action(event) }

inline fun Scene.onDragExited(
    noinline action: (DragEvent) -> Unit
) = setOnDragExited { event -> action(event) }

inline fun Scene.onDragOver(
    noinline action: (DragEvent) -> Unit
) = setOnDragOver { event -> action(event) }

inline fun Scene.onInputMethodTextChanged(
    noinline action: (InputMethodEvent) -> Unit
) = setOnInputMethodTextChanged { event -> action(event) }

inline fun Scene.onKeyPressed(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyPressed { event -> action(event) }

inline fun Scene.onKeyReleased(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyReleased { event -> action(event) }

inline fun Scene.onKeyTyped(
    noinline action: (KeyEvent) -> Unit
) = setOnKeyTyped { event -> action(event) }

inline fun Scene.onMouseClicked(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseClicked { event -> action(event) }

inline fun Scene.onMouseDragEntered(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragEntered { event -> action(event) }

inline fun Scene.onMouseDragExited(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragExited { event -> action(event) }

inline fun Scene.onMouseDragged(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseDragged { event -> action(event) }

inline fun Scene.onMouseDragOver(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragOver { event -> action(event) }

inline fun Scene.onMouseDragReleased(
    noinline action: (MouseDragEvent) -> Unit
) = setOnMouseDragReleased { event -> action(event) }

inline fun Scene.onMouseEntered(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseEntered { event -> action(event) }

inline fun Scene.onMouseExited(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseExited { event -> action(event) }

inline fun Scene.onMouseMoved(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseMoved { event -> action(event) }

inline fun Scene.onMousePressed(
    noinline action: (MouseEvent) -> Unit
) = setOnMousePressed { event -> action(event) }

inline fun Scene.onMouseReleased(
    noinline action: (MouseEvent) -> Unit
) = setOnMouseReleased { event -> action(event) }

inline fun Scene.onRotate(
    noinline action: (RotateEvent) -> Unit
) = setOnRotate { event -> action(event) }

inline fun Scene.onRotationFinished(
    noinline action: (RotateEvent) -> Unit
) = setOnRotationFinished { event -> action(event) }

inline fun Scene.onRotationStarted(
    noinline action: (RotateEvent) -> Unit
) = setOnRotationStarted { event -> action(event) }

inline fun Scene.onScroll(
    noinline action: (ScrollEvent) -> Unit
) = setOnScroll { event -> action(event) }

inline fun Scene.onScrollFinished(
    noinline action: (ScrollEvent) -> Unit
) = setOnScrollFinished { event -> action(event) }

inline fun Scene.onScrollStarted(
    noinline action: (ScrollEvent) -> Unit
) = setOnScrollStarted { event -> action(event) }

inline fun Scene.onSwipeDown(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeDown { event -> action(event) }

inline fun Scene.onSwipeLeft(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeLeft { event -> action(event) }

inline fun Scene.onSwipeRight(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeRight { event -> action(event) }

inline fun Scene.onSwipeUp(
    noinline action: (SwipeEvent) -> Unit
) = setOnSwipeUp { event -> action(event) }

inline fun Scene.onTouchMoved(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchMoved { event -> action(event) }

inline fun Scene.setOnTouchPressed(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchPressed { event -> action(event) }

inline fun Scene.onTouchReleased(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchReleased { event -> action(event) }

inline fun Scene.onTouchStationary(
    noinline action: (TouchEvent) -> Unit
) = setOnTouchStationary { event -> action(event) }

inline fun Scene.onZoom(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoom { event -> action(event) }

inline fun Scene.onZoomFinished(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoomFinished { event -> action(event) }

inline fun Scene.onZoomStarted(
    noinline action: (ZoomEvent) -> Unit
) = setOnZoomStarted { event -> action(event) }