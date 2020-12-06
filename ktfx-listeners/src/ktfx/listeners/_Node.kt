@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.Node
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
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Node.setOnDragEntered
 */
public inline fun Node.onDragEntered(noinline action: (DragEvent) -> Unit) {
    return setOnDragEntered(action)
}

/**
 * @see Node.setOnDragExited
 */
public inline fun Node.onDragExited(noinline action: (DragEvent) -> Unit) {
    return setOnDragExited(action)
}

/**
 * @see Node.setOnDragOver
 */
public inline fun Node.onDragOver(noinline action: (DragEvent) -> Unit) {
    return setOnDragOver(action)
}

/**
 * @see Node.setOnDragDropped
 */
public inline fun Node.onDragDropped(noinline action: (DragEvent) -> Unit) {
    return setOnDragDropped(action)
}

/**
 * @see Node.setOnDragDone
 */
public inline fun Node.onDragDone(noinline action: (DragEvent) -> Unit) {
    return setOnDragDone(action)
}

/**
 * @see Node.setOnContextMenuRequested
 */
public inline fun Node.onContextMenuRequested(noinline action: (ContextMenuEvent) -> Unit) {
    return setOnContextMenuRequested(action)
}

/**
 * @see Node.setOnMouseClicked
 */
public inline fun Node.onMouseClicked(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseClicked(action)
}

/**
 * @see Node.setOnMouseDragged
 */
public inline fun Node.onMouseDragged(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseDragged(action)
}

/**
 * @see Node.setOnMouseEntered
 */
public inline fun Node.onMouseEntered(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseEntered(action)
}

/**
 * @see Node.setOnMouseExited
 */
public inline fun Node.onMouseExited(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseExited(action)
}

/**
 * @see Node.setOnMouseMoved
 */
public inline fun Node.onMouseMoved(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseMoved(action)
}

/**
 * @see Node.setOnMousePressed
 */
public inline fun Node.onMousePressed(noinline action: (MouseEvent) -> Unit) {
    return setOnMousePressed(action)
}

/**
 * @see Node.setOnMouseReleased
 */
public inline fun Node.onMouseReleased(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseReleased(action)
}

/**
 * @see Node.setOnDragDetected
 */
public inline fun Node.onDragDetected(noinline action: (MouseEvent) -> Unit) {
    return setOnDragDetected(action)
}

/**
 * @see Node.setOnMouseDragOver
 */
public inline fun Node.onMouseDragOver(noinline action: (MouseDragEvent) -> Unit) {
    return setOnMouseDragOver(action)
}

/**
 * @see Node.setOnMouseDragReleased
 */
public inline fun Node.onMouseDragReleased(noinline action: (MouseDragEvent) -> Unit) {
    return setOnMouseDragReleased(action)
}

/**
 * @see Node.setOnMouseDragEntered
 */
public inline fun Node.onMouseDragEntered(noinline action: (MouseDragEvent) -> Unit) {
    return setOnMouseDragEntered(action)
}

/**
 * @see Node.setOnMouseDragExited
 */
public inline fun Node.onMouseDragExited(noinline action: (MouseDragEvent) -> Unit) {
    return setOnMouseDragExited(action)
}

/**
 * @see Node.setOnScrollStarted
 */
public inline fun Node.onScrollStarted(noinline action: (ScrollEvent) -> Unit) {
    return setOnScrollStarted(action)
}

/**
 * @see Node.setOnScroll
 */
public inline fun Node.onScroll(noinline action: (ScrollEvent) -> Unit) {
    return setOnScroll(action)
}

/**
 * @see Node.setOnScrollFinished
 */
public inline fun Node.onScrollFinished(noinline action: (ScrollEvent) -> Unit) {
    return setOnScrollFinished(action)
}

/**
 * @see Node.setOnRotationStarted
 */
public inline fun Node.onRotationStarted(noinline action: (RotateEvent) -> Unit) {
    return setOnRotationStarted(action)
}

/**
 * @see Node.setOnRotate
 */
public inline fun Node.onRotate(noinline action: (RotateEvent) -> Unit) {
    return setOnRotate(action)
}

/**
 * @see Node.setOnRotationFinished
 */
public inline fun Node.onRotationFinished(noinline action: (RotateEvent) -> Unit) {
    return setOnRotationFinished(action)
}

/**
 * @see Node.setOnZoomStarted
 */
public inline fun Node.onZoomStarted(noinline action: (ZoomEvent) -> Unit) {
    return setOnZoomStarted(action)
}

/**
 * @see Node.setOnZoom
 */
public inline fun Node.onZoom(noinline action: (ZoomEvent) -> Unit) {
    return setOnZoom(action)
}

/**
 * @see Node.setOnZoomFinished
 */
public inline fun Node.onZoomFinished(noinline action: (ZoomEvent) -> Unit) {
    return setOnZoomFinished(action)
}

/**
 * @see Node.setOnSwipeUp
 */
public inline fun Node.onSwipeUp(noinline action: (SwipeEvent) -> Unit) {
    return setOnSwipeUp(action)
}

/**
 * @see Node.setOnSwipeDown
 */
public inline fun Node.onSwipeDown(noinline action: (SwipeEvent) -> Unit) {
    return setOnSwipeDown(action)
}

/**
 * @see Node.setOnSwipeLeft
 */
public inline fun Node.onSwipeLeft(noinline action: (SwipeEvent) -> Unit) {
    return setOnSwipeLeft(action)
}

/**
 * @see Node.setOnSwipeRight
 */
public inline fun Node.onSwipeRight(noinline action: (SwipeEvent) -> Unit) {
    return setOnSwipeRight(action)
}

/**
 * @see Node.setOnTouchPressed
 */
public inline fun Node.onTouchPressed(noinline action: (TouchEvent) -> Unit) {
    return setOnTouchPressed(action)
}

/**
 * @see Node.setOnTouchMoved
 */
public inline fun Node.onTouchMoved(noinline action: (TouchEvent) -> Unit) {
    return setOnTouchMoved(action)
}

/**
 * @see Node.setOnTouchReleased
 */
public inline fun Node.onTouchReleased(noinline action: (TouchEvent) -> Unit) {
    return setOnTouchReleased(action)
}

/**
 * @see Node.setOnTouchStationary
 */
public inline fun Node.onTouchStationary(noinline action: (TouchEvent) -> Unit) {
    return setOnTouchStationary(action)
}

/**
 * @see Node.setOnKeyPressed
 */
public inline fun Node.onKeyPressed(noinline action: (KeyEvent) -> Unit) {
    return setOnKeyPressed(action)
}

/**
 * @see Node.setOnKeyReleased
 */
public inline fun Node.onKeyReleased(noinline action: (KeyEvent) -> Unit) {
    return setOnKeyReleased(action)
}

/**
 * @see Node.setOnKeyTyped
 */
public inline fun Node.onKeyTyped(noinline action: (KeyEvent) -> Unit) {
    return setOnKeyTyped(action)
}

/**
 * @see Node.setOnInputMethodTextChanged
 */
public inline fun Node.onInputMethodTextChanged(noinline action: (InputMethodEvent) -> Unit) {
    return setOnInputMethodTextChanged(action)
}
