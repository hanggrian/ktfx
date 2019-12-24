package ktfx.listeners

import javafx.scene.BaseSceneTest
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

class SceneTest : BaseSceneTest() {

    override fun Scene.callOnMouseClicked(action: (MouseEvent) -> Unit) = onMouseClicked(action)
    override fun Scene.callOnMouseDragged(action: (MouseEvent) -> Unit) = onMouseDragged(action)
    override fun Scene.callOnMouseEntered(action: (MouseEvent) -> Unit) = onMouseEntered(action)
    override fun Scene.callOnMouseExited(action: (MouseEvent) -> Unit) = onMouseExited(action)
    override fun Scene.callOnMouseMoved(action: (MouseEvent) -> Unit) = onMouseMoved(action)
    override fun Scene.callOnMousePressed(action: (MouseEvent) -> Unit) = onMousePressed(action)
    override fun Scene.callOnMouseReleased(action: (MouseEvent) -> Unit) = onMouseReleased(action)
    override fun Scene.callOnDragDetected(action: (MouseEvent) -> Unit) = onDragDetected(action)
    override fun Scene.callOnMouseDragOver(action: (MouseDragEvent) -> Unit) = onMouseDragOver(action)
    override fun Scene.callOnMouseDragReleased(action: (MouseDragEvent) -> Unit) = onMouseDragReleased(action)
    override fun Scene.callOnMouseDragEntered(action: (MouseDragEvent) -> Unit) = onMouseDragEntered(action)
    override fun Scene.callOnMouseDragExited(action: (MouseDragEvent) -> Unit) = onMouseDragExited(action)
    override fun Scene.callOnScrollStarted(action: (ScrollEvent) -> Unit) = onScrollStarted(action)
    override fun Scene.callOnScroll(action: (ScrollEvent) -> Unit) = onScroll(action)
    override fun Scene.callOnScrollFinished(action: (ScrollEvent) -> Unit) = onScrollFinished(action)
    override fun Scene.callOnRotateStarted(action: (RotateEvent) -> Unit) = onRotateStarted(action)
    override fun Scene.callOnRotate(action: (RotateEvent) -> Unit) = onRotate(action)
    override fun Scene.callOnRotateFinished(action: (RotateEvent) -> Unit) = onRotateFinished(action)
    override fun Scene.callOnZoomStarted(action: (ZoomEvent) -> Unit) = onZoomStarted(action)
    override fun Scene.callOnZoom(action: (ZoomEvent) -> Unit) = onZoom(action)
    override fun Scene.callOnZoomFinished(action: (ZoomEvent) -> Unit) = onZoomFinished(action)
    override fun Scene.callOnSwipeUp(action: (SwipeEvent) -> Unit) = onSwipeUp(action)
    override fun Scene.callOnSwipeDown(action: (SwipeEvent) -> Unit) = onSwipeDown(action)
    override fun Scene.callOnSwipeRight(action: (SwipeEvent) -> Unit) = onSwipeRight(action)
    override fun Scene.callOnSwipeLeft(action: (SwipeEvent) -> Unit) = onSwipeLeft(action)
    override fun Scene.callOnTouchPressed(action: (TouchEvent) -> Unit) = onTouchPressed(action)
    override fun Scene.callOnTouchMoved(action: (TouchEvent) -> Unit) = onTouchMoved(action)
    override fun Scene.callOnTouchReleased(action: (TouchEvent) -> Unit) = onTouchReleased(action)
    override fun Scene.callOnTouchStationary(action: (TouchEvent) -> Unit) = onTouchStationary(action)
    override fun Scene.callOnDragEntered(action: (DragEvent) -> Unit) = onDragEntered(action)
    override fun Scene.callOnDragExited(action: (DragEvent) -> Unit) = onDragExited(action)
    override fun Scene.callOnDragOver(action: (DragEvent) -> Unit) = onDragOver(action)
    override fun Scene.callOnDragDropped(action: (DragEvent) -> Unit) = onDragDropped(action)
    override fun Scene.callOnDragDone(action: (DragEvent) -> Unit) = onDragDone(action)
    override fun Scene.callOnKeyPressed(action: (KeyEvent) -> Unit) = onKeyPressed(action)
    override fun Scene.callOnKeyReleased(action: (KeyEvent) -> Unit) = onKeyReleased(action)
    override fun Scene.callOnKeyTyped(action: (KeyEvent) -> Unit) = onKeyTyped(action)
    override fun Scene.callOnInputMethodTextChanged(action: (InputMethodEvent) -> Unit) =
        onInputMethodTextChanged(action)

    override fun Scene.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit) = onContextMenuRequested(action)
}