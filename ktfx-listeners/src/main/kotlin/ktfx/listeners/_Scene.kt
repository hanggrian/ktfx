@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

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
public inline fun Scene.onMouseClicked(noinline action: (MouseEvent) -> Unit): Unit =
        setOnMouseClicked(action)

/**
 * @see Scene.setOnMouseDragged
 */
public inline fun Scene.onMouseDragged(noinline action: (MouseEvent) -> Unit): Unit =
        setOnMouseDragged(action)

/**
 * @see Scene.setOnMouseEntered
 */
public inline fun Scene.onMouseEntered(noinline action: (MouseEvent) -> Unit): Unit =
        setOnMouseEntered(action)

/**
 * @see Scene.setOnMouseExited
 */
public inline fun Scene.onMouseExited(noinline action: (MouseEvent) -> Unit): Unit =
        setOnMouseExited(action)

/**
 * @see Scene.setOnMouseMoved
 */
public inline fun Scene.onMouseMoved(noinline action: (MouseEvent) -> Unit): Unit =
        setOnMouseMoved(action)

/**
 * @see Scene.setOnMousePressed
 */
public inline fun Scene.onMousePressed(noinline action: (MouseEvent) -> Unit): Unit =
        setOnMousePressed(action)

/**
 * @see Scene.setOnMouseReleased
 */
public inline fun Scene.onMouseReleased(noinline action: (MouseEvent) -> Unit): Unit =
        setOnMouseReleased(action)

/**
 * @see Scene.setOnDragDetected
 */
public inline fun Scene.onDragDetected(noinline action: (MouseEvent) -> Unit): Unit =
        setOnDragDetected(action)

/**
 * @see Scene.setOnMouseDragOver
 */
public inline fun Scene.onMouseDragOver(noinline action: (MouseDragEvent) -> Unit): Unit =
        setOnMouseDragOver(action)

/**
 * @see Scene.setOnMouseDragReleased
 */
public inline fun Scene.onMouseDragReleased(noinline action: (MouseDragEvent) -> Unit): Unit =
        setOnMouseDragReleased(action)

/**
 * @see Scene.setOnMouseDragEntered
 */
public inline fun Scene.onMouseDragEntered(noinline action: (MouseDragEvent) -> Unit): Unit =
        setOnMouseDragEntered(action)

/**
 * @see Scene.setOnMouseDragExited
 */
public inline fun Scene.onMouseDragExited(noinline action: (MouseDragEvent) -> Unit): Unit =
        setOnMouseDragExited(action)

/**
 * @see Scene.setOnScrollStarted
 */
public inline fun Scene.onScrollStarted(noinline action: (ScrollEvent) -> Unit): Unit =
        setOnScrollStarted(action)

/**
 * @see Scene.setOnScroll
 */
public inline fun Scene.onScroll(noinline action: (ScrollEvent) -> Unit): Unit = setOnScroll(action)

/**
 * @see Scene.setOnScrollFinished
 */
public inline fun Scene.onScrollFinished(noinline action: (ScrollEvent) -> Unit): Unit =
        setOnScrollFinished(action)

/**
 * @see Scene.setOnRotationStarted
 */
public inline fun Scene.onRotationStarted(noinline action: (RotateEvent) -> Unit): Unit =
        setOnRotationStarted(action)

/**
 * @see Scene.setOnRotate
 */
public inline fun Scene.onRotate(noinline action: (RotateEvent) -> Unit): Unit = setOnRotate(action)

/**
 * @see Scene.setOnRotationFinished
 */
public inline fun Scene.onRotationFinished(noinline action: (RotateEvent) -> Unit): Unit =
        setOnRotationFinished(action)

/**
 * @see Scene.setOnZoomStarted
 */
public inline fun Scene.onZoomStarted(noinline action: (ZoomEvent) -> Unit): Unit =
        setOnZoomStarted(action)

/**
 * @see Scene.setOnZoom
 */
public inline fun Scene.onZoom(noinline action: (ZoomEvent) -> Unit): Unit = setOnZoom(action)

/**
 * @see Scene.setOnZoomFinished
 */
public inline fun Scene.onZoomFinished(noinline action: (ZoomEvent) -> Unit): Unit =
        setOnZoomFinished(action)

/**
 * @see Scene.setOnSwipeUp
 */
public inline fun Scene.onSwipeUp(noinline action: (SwipeEvent) -> Unit): Unit =
        setOnSwipeUp(action)

/**
 * @see Scene.setOnSwipeDown
 */
public inline fun Scene.onSwipeDown(noinline action: (SwipeEvent) -> Unit): Unit =
        setOnSwipeDown(action)

/**
 * @see Scene.setOnSwipeLeft
 */
public inline fun Scene.onSwipeLeft(noinline action: (SwipeEvent) -> Unit): Unit =
        setOnSwipeLeft(action)

/**
 * @see Scene.setOnSwipeRight
 */
public inline fun Scene.onSwipeRight(noinline action: (SwipeEvent) -> Unit): Unit =
        setOnSwipeRight(action)

/**
 * @see Scene.setOnTouchPressed
 */
public inline fun Scene.onTouchPressed(noinline action: (TouchEvent) -> Unit): Unit =
        setOnTouchPressed(action)

/**
 * @see Scene.setOnTouchMoved
 */
public inline fun Scene.onTouchMoved(noinline action: (TouchEvent) -> Unit): Unit =
        setOnTouchMoved(action)

/**
 * @see Scene.setOnTouchReleased
 */
public inline fun Scene.onTouchReleased(noinline action: (TouchEvent) -> Unit): Unit =
        setOnTouchReleased(action)

/**
 * @see Scene.setOnTouchStationary
 */
public inline fun Scene.onTouchStationary(noinline action: (TouchEvent) -> Unit): Unit =
        setOnTouchStationary(action)

/**
 * @see Scene.setOnDragEntered
 */
public inline fun Scene.onDragEntered(noinline action: (DragEvent) -> Unit): Unit =
        setOnDragEntered(action)

/**
 * @see Scene.setOnDragExited
 */
public inline fun Scene.onDragExited(noinline action: (DragEvent) -> Unit): Unit =
        setOnDragExited(action)

/**
 * @see Scene.setOnDragOver
 */
public inline fun Scene.onDragOver(noinline action: (DragEvent) -> Unit): Unit =
        setOnDragOver(action)

/**
 * @see Scene.setOnDragDropped
 */
public inline fun Scene.onDragDropped(noinline action: (DragEvent) -> Unit): Unit =
        setOnDragDropped(action)

/**
 * @see Scene.setOnDragDone
 */
public inline fun Scene.onDragDone(noinline action: (DragEvent) -> Unit): Unit =
        setOnDragDone(action)

/**
 * @see Scene.setOnKeyPressed
 */
public inline fun Scene.onKeyPressed(noinline action: (KeyEvent) -> Unit): Unit =
        setOnKeyPressed(action)

/**
 * @see Scene.setOnKeyReleased
 */
public inline fun Scene.onKeyReleased(noinline action: (KeyEvent) -> Unit): Unit =
        setOnKeyReleased(action)

/**
 * @see Scene.setOnKeyTyped
 */
public inline fun Scene.onKeyTyped(noinline action: (KeyEvent) -> Unit): Unit =
        setOnKeyTyped(action)

/**
 * @see Scene.setOnInputMethodTextChanged
 */
public inline fun Scene.onInputMethodTextChanged(noinline action: (InputMethodEvent) -> Unit): Unit
        = setOnInputMethodTextChanged(action)

/**
 * @see Scene.setOnContextMenuRequested
 */
public inline fun Scene.onContextMenuRequested(noinline action: (ContextMenuEvent) -> Unit): Unit =
        setOnContextMenuRequested(action)
