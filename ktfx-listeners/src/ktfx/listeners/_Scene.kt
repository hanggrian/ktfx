@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

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
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Scene.setOnMouseClicked
 */
inline fun Scene.onMouseClicked(noinline action: (MouseEvent) -> Unit): Unit =
    setOnMouseClicked(action)

/**
 * @see Scene.setOnMouseDragged
 */
inline fun Scene.onMouseDragged(noinline action: (MouseEvent) -> Unit): Unit =
    setOnMouseDragged(action)

/**
 * @see Scene.setOnMouseEntered
 */
inline fun Scene.onMouseEntered(noinline action: (MouseEvent) -> Unit): Unit =
    setOnMouseEntered(action)

/**
 * @see Scene.setOnMouseExited
 */
inline fun Scene.onMouseExited(noinline action: (MouseEvent) -> Unit): Unit =
    setOnMouseExited(action)

/**
 * @see Scene.setOnMouseMoved
 */
inline fun Scene.onMouseMoved(noinline action: (MouseEvent) -> Unit): Unit = setOnMouseMoved(action)

/**
 * @see Scene.setOnMousePressed
 */
inline fun Scene.onMousePressed(noinline action: (MouseEvent) -> Unit): Unit =
    setOnMousePressed(action)

/**
 * @see Scene.setOnMouseReleased
 */
inline fun Scene.onMouseReleased(noinline action: (MouseEvent) -> Unit): Unit =
    setOnMouseReleased(action)

/**
 * @see Scene.setOnDragDetected
 */
inline fun Scene.onDragDetected(noinline action: (MouseEvent) -> Unit): Unit =
    setOnDragDetected(action)

/**
 * @see Scene.setOnMouseDragOver
 */
inline fun Scene.onMouseDragOver(noinline action: (MouseDragEvent) -> Unit): Unit =
    setOnMouseDragOver(action)

/**
 * @see Scene.setOnMouseDragReleased
 */
inline fun Scene.onMouseDragReleased(noinline action: (MouseDragEvent) -> Unit): Unit =
    setOnMouseDragReleased(action)

/**
 * @see Scene.setOnMouseDragEntered
 */
inline fun Scene.onMouseDragEntered(noinline action: (MouseDragEvent) -> Unit): Unit =
    setOnMouseDragEntered(action)

/**
 * @see Scene.setOnMouseDragExited
 */
inline fun Scene.onMouseDragExited(noinline action: (MouseDragEvent) -> Unit): Unit =
    setOnMouseDragExited(action)

/**
 * @see Scene.setOnScrollStarted
 */
inline fun Scene.onScrollStarted(noinline action: (ScrollEvent) -> Unit): Unit =
    setOnScrollStarted(action)

/**
 * @see Scene.setOnScroll
 */
inline fun Scene.onScroll(noinline action: (ScrollEvent) -> Unit): Unit = setOnScroll(action)

/**
 * @see Scene.setOnScrollFinished
 */
inline fun Scene.onScrollFinished(noinline action: (ScrollEvent) -> Unit): Unit =
    setOnScrollFinished(action)

/**
 * @see Scene.setOnRotationStarted
 */
inline fun Scene.onRotationStarted(noinline action: (RotateEvent) -> Unit): Unit =
    setOnRotationStarted(action)

/**
 * @see Scene.setOnRotate
 */
inline fun Scene.onRotate(noinline action: (RotateEvent) -> Unit): Unit = setOnRotate(action)

/**
 * @see Scene.setOnRotationFinished
 */
inline fun Scene.onRotationFinished(noinline action: (RotateEvent) -> Unit): Unit =
    setOnRotationFinished(action)

/**
 * @see Scene.setOnZoomStarted
 */
inline fun Scene.onZoomStarted(noinline action: (ZoomEvent) -> Unit): Unit =
    setOnZoomStarted(action)

/**
 * @see Scene.setOnZoom
 */
inline fun Scene.onZoom(noinline action: (ZoomEvent) -> Unit): Unit = setOnZoom(action)

/**
 * @see Scene.setOnZoomFinished
 */
inline fun Scene.onZoomFinished(noinline action: (ZoomEvent) -> Unit): Unit =
    setOnZoomFinished(action)

/**
 * @see Scene.setOnSwipeUp
 */
inline fun Scene.onSwipeUp(noinline action: (SwipeEvent) -> Unit): Unit = setOnSwipeUp(action)

/**
 * @see Scene.setOnSwipeDown
 */
inline fun Scene.onSwipeDown(noinline action: (SwipeEvent) -> Unit): Unit = setOnSwipeDown(action)

/**
 * @see Scene.setOnSwipeLeft
 */
inline fun Scene.onSwipeLeft(noinline action: (SwipeEvent) -> Unit): Unit = setOnSwipeLeft(action)

/**
 * @see Scene.setOnSwipeRight
 */
inline fun Scene.onSwipeRight(noinline action: (SwipeEvent) -> Unit): Unit = setOnSwipeRight(action)

/**
 * @see Scene.setOnTouchPressed
 */
inline fun Scene.onTouchPressed(noinline action: (TouchEvent) -> Unit): Unit =
    setOnTouchPressed(action)

/**
 * @see Scene.setOnTouchMoved
 */
inline fun Scene.onTouchMoved(noinline action: (TouchEvent) -> Unit): Unit = setOnTouchMoved(action)

/**
 * @see Scene.setOnTouchReleased
 */
inline fun Scene.onTouchReleased(noinline action: (TouchEvent) -> Unit): Unit =
    setOnTouchReleased(action)

/**
 * @see Scene.setOnTouchStationary
 */
inline fun Scene.onTouchStationary(noinline action: (TouchEvent) -> Unit): Unit =
    setOnTouchStationary(action)

/**
 * @see Scene.setOnDragEntered
 */
inline fun Scene.onDragEntered(noinline action: (DragEvent) -> Unit): Unit =
    setOnDragEntered(action)

/**
 * @see Scene.setOnDragExited
 */
inline fun Scene.onDragExited(noinline action: (DragEvent) -> Unit): Unit = setOnDragExited(action)

/**
 * @see Scene.setOnDragOver
 */
inline fun Scene.onDragOver(noinline action: (DragEvent) -> Unit): Unit = setOnDragOver(action)

/**
 * @see Scene.setOnDragDropped
 */
inline fun Scene.onDragDropped(noinline action: (DragEvent) -> Unit): Unit =
    setOnDragDropped(action)

/**
 * @see Scene.setOnDragDone
 */
inline fun Scene.onDragDone(noinline action: (DragEvent) -> Unit): Unit = setOnDragDone(action)

/**
 * @see Scene.setOnKeyPressed
 */
inline fun Scene.onKeyPressed(noinline action: (KeyEvent) -> Unit): Unit = setOnKeyPressed(action)

/**
 * @see Scene.setOnKeyReleased
 */
inline fun Scene.onKeyReleased(noinline action: (KeyEvent) -> Unit): Unit = setOnKeyReleased(action)

/**
 * @see Scene.setOnKeyTyped
 */
inline fun Scene.onKeyTyped(noinline action: (KeyEvent) -> Unit): Unit = setOnKeyTyped(action)

/**
 * @see Scene.setOnInputMethodTextChanged
 */
inline fun Scene.onInputMethodTextChanged(noinline action: (InputMethodEvent) -> Unit): Unit =
    setOnInputMethodTextChanged(action)

/**
 * @see Scene.setOnContextMenuRequested
 */
inline fun Scene.onContextMenuRequested(noinline action: (ContextMenuEvent) -> Unit): Unit =
    setOnContextMenuRequested(action)
