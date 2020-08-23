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
inline fun Node.onDragEntered(noinline action: (DragEvent) -> Unit) {
    return setOnDragEntered(action)
}

/**
 * @see Node.setOnDragExited
 */
inline fun Node.onDragExited(noinline action: (DragEvent) -> Unit) {
    return setOnDragExited(action)
}

/**
 * @see Node.setOnDragOver
 */
inline fun Node.onDragOver(noinline action: (DragEvent) -> Unit) {
    return setOnDragOver(action)
}

/**
 * @see Node.setOnDragDropped
 */
inline fun Node.onDragDropped(noinline action: (DragEvent) -> Unit) {
    return setOnDragDropped(action)
}

/**
 * @see Node.setOnDragDone
 */
inline fun Node.onDragDone(noinline action: (DragEvent) -> Unit) {
    return setOnDragDone(action)
}

/**
 * @see Node.setOnContextMenuRequested
 */
inline fun Node.onContextMenuRequested(noinline action: (ContextMenuEvent) -> Unit) {
    return setOnContextMenuRequested(action)
}

/**
 * @see Node.setOnMouseClicked
 */
inline fun Node.onMouseClicked(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseClicked(action)
}

/**
 * @see Node.setOnMouseDragged
 */
inline fun Node.onMouseDragged(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseDragged(action)
}

/**
 * @see Node.setOnMouseEntered
 */
inline fun Node.onMouseEntered(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseEntered(action)
}

/**
 * @see Node.setOnMouseExited
 */
inline fun Node.onMouseExited(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseExited(action)
}

/**
 * @see Node.setOnMouseMoved
 */
inline fun Node.onMouseMoved(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseMoved(action)
}

/**
 * @see Node.setOnMousePressed
 */
inline fun Node.onMousePressed(noinline action: (MouseEvent) -> Unit) {
    return setOnMousePressed(action)
}

/**
 * @see Node.setOnMouseReleased
 */
inline fun Node.onMouseReleased(noinline action: (MouseEvent) -> Unit) {
    return setOnMouseReleased(action)
}

/**
 * @see Node.setOnDragDetected
 */
inline fun Node.onDragDetected(noinline action: (MouseEvent) -> Unit) {
    return setOnDragDetected(action)
}

/**
 * @see Node.setOnMouseDragOver
 */
inline fun Node.onMouseDragOver(noinline action: (MouseDragEvent) -> Unit) {
    return setOnMouseDragOver(action)
}

/**
 * @see Node.setOnMouseDragReleased
 */
inline fun Node.onMouseDragReleased(noinline action: (MouseDragEvent) -> Unit) {
    return setOnMouseDragReleased(action)
}

/**
 * @see Node.setOnMouseDragEntered
 */
inline fun Node.onMouseDragEntered(noinline action: (MouseDragEvent) -> Unit) {
    return setOnMouseDragEntered(action)
}

/**
 * @see Node.setOnMouseDragExited
 */
inline fun Node.onMouseDragExited(noinline action: (MouseDragEvent) -> Unit) {
    return setOnMouseDragExited(action)
}

/**
 * @see Node.setOnScrollStarted
 */
inline fun Node.onScrollStarted(noinline action: (ScrollEvent) -> Unit) {
    return setOnScrollStarted(action)
}

/**
 * @see Node.setOnScroll
 */
inline fun Node.onScroll(noinline action: (ScrollEvent) -> Unit) {
    return setOnScroll(action)
}

/**
 * @see Node.setOnScrollFinished
 */
inline fun Node.onScrollFinished(noinline action: (ScrollEvent) -> Unit) {
    return setOnScrollFinished(action)
}

/**
 * @see Node.setOnRotationStarted
 */
inline fun Node.onRotationStarted(noinline action: (RotateEvent) -> Unit) {
    return setOnRotationStarted(action)
}

/**
 * @see Node.setOnRotate
 */
inline fun Node.onRotate(noinline action: (RotateEvent) -> Unit) {
    return setOnRotate(action)
}

/**
 * @see Node.setOnRotationFinished
 */
inline fun Node.onRotationFinished(noinline action: (RotateEvent) -> Unit) {
    return setOnRotationFinished(action)
}

/**
 * @see Node.setOnZoomStarted
 */
inline fun Node.onZoomStarted(noinline action: (ZoomEvent) -> Unit) {
    return setOnZoomStarted(action)
}

/**
 * @see Node.setOnZoom
 */
inline fun Node.onZoom(noinline action: (ZoomEvent) -> Unit) {
    return setOnZoom(action)
}

/**
 * @see Node.setOnZoomFinished
 */
inline fun Node.onZoomFinished(noinline action: (ZoomEvent) -> Unit) {
    return setOnZoomFinished(action)
}

/**
 * @see Node.setOnSwipeUp
 */
inline fun Node.onSwipeUp(noinline action: (SwipeEvent) -> Unit) {
    return setOnSwipeUp(action)
}

/**
 * @see Node.setOnSwipeDown
 */
inline fun Node.onSwipeDown(noinline action: (SwipeEvent) -> Unit) {
    return setOnSwipeDown(action)
}

/**
 * @see Node.setOnSwipeLeft
 */
inline fun Node.onSwipeLeft(noinline action: (SwipeEvent) -> Unit) {
    return setOnSwipeLeft(action)
}

/**
 * @see Node.setOnSwipeRight
 */
inline fun Node.onSwipeRight(noinline action: (SwipeEvent) -> Unit) {
    return setOnSwipeRight(action)
}

/**
 * @see Node.setOnTouchPressed
 */
inline fun Node.onTouchPressed(noinline action: (TouchEvent) -> Unit) {
    return setOnTouchPressed(action)
}

/**
 * @see Node.setOnTouchMoved
 */
inline fun Node.onTouchMoved(noinline action: (TouchEvent) -> Unit) {
    return setOnTouchMoved(action)
}

/**
 * @see Node.setOnTouchReleased
 */
inline fun Node.onTouchReleased(noinline action: (TouchEvent) -> Unit) {
    return setOnTouchReleased(action)
}

/**
 * @see Node.setOnTouchStationary
 */
inline fun Node.onTouchStationary(noinline action: (TouchEvent) -> Unit) {
    return setOnTouchStationary(action)
}

/**
 * @see Node.setOnKeyPressed
 */
inline fun Node.onKeyPressed(noinline action: (KeyEvent) -> Unit) {
    return setOnKeyPressed(action)
}

/**
 * @see Node.setOnKeyReleased
 */
inline fun Node.onKeyReleased(noinline action: (KeyEvent) -> Unit) {
    return setOnKeyReleased(action)
}

/**
 * @see Node.setOnKeyTyped
 */
inline fun Node.onKeyTyped(noinline action: (KeyEvent) -> Unit) {
    return setOnKeyTyped(action)
}

/**
 * @see Node.setOnInputMethodTextChanged
 */
inline fun Node.onInputMethodTextChanged(noinline action: (InputMethodEvent) -> Unit) {
    return setOnInputMethodTextChanged(action)
}
