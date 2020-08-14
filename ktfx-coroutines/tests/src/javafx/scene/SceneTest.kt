package ktfx.coroutines

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
import kotlinx.coroutines.Dispatchers

class SceneTest : BaseSceneTest() {

    override fun Scene.callOnMouseClicked(action: (MouseEvent) -> Unit) =
        onMouseClicked(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMouseDragged(action: (MouseEvent) -> Unit) =
        onMouseDragged(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMouseEntered(action: (MouseEvent) -> Unit) =
        onMouseEntered(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMouseExited(action: (MouseEvent) -> Unit) =
        onMouseExited(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMouseMoved(action: (MouseEvent) -> Unit) =
        onMouseMoved(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMousePressed(action: (MouseEvent) -> Unit) =
        onMousePressed(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMouseReleased(action: (MouseEvent) -> Unit) =
        onMouseReleased(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnDragDetected(action: (MouseEvent) -> Unit) =
        onDragDetected(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMouseDragOver(action: (MouseDragEvent) -> Unit) =
        onMouseDragOver(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMouseDragReleased(action: (MouseDragEvent) -> Unit) =
        onMouseDragReleased(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMouseDragEntered(action: (MouseDragEvent) -> Unit) =
        onMouseDragEntered(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnMouseDragExited(action: (MouseDragEvent) -> Unit) =
        onMouseDragExited(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnScrollStarted(action: (ScrollEvent) -> Unit) =
        onScrollStarted(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnScroll(action: (ScrollEvent) -> Unit) =
        onScroll(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnScrollFinished(action: (ScrollEvent) -> Unit) =
        onScrollFinished(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnRotationStarted(action: (RotateEvent) -> Unit) =
        onRotationStarted(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnRotate(action: (RotateEvent) -> Unit) =
        onRotate(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnRotationFinished(action: (RotateEvent) -> Unit) =
        onRotationFinished(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnZoomStarted(action: (ZoomEvent) -> Unit) =
        onZoomStarted(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnZoom(action: (ZoomEvent) -> Unit) =
        onZoom(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnZoomFinished(action: (ZoomEvent) -> Unit) =
        onZoomFinished(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnSwipeUp(action: (SwipeEvent) -> Unit) =
        onSwipeUp(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnSwipeDown(action: (SwipeEvent) -> Unit) =
        onSwipeDown(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnSwipeRight(action: (SwipeEvent) -> Unit) =
        onSwipeRight(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnSwipeLeft(action: (SwipeEvent) -> Unit) =
        onSwipeLeft(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnTouchPressed(action: (TouchEvent) -> Unit) =
        onTouchPressed(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnTouchMoved(action: (TouchEvent) -> Unit) =
        onTouchMoved(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnTouchReleased(action: (TouchEvent) -> Unit) =
        onTouchReleased(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnTouchStationary(action: (TouchEvent) -> Unit) =
        onTouchStationary(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnDragEntered(action: (DragEvent) -> Unit) =
        onDragEntered(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnDragExited(action: (DragEvent) -> Unit) =
        onDragExited(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnDragOver(action: (DragEvent) -> Unit) =
        onDragOver(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnDragDropped(action: (DragEvent) -> Unit) =
        onDragDropped(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnDragDone(action: (DragEvent) -> Unit) =
        onDragDone(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnKeyPressed(action: (KeyEvent) -> Unit) =
        onKeyPressed(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnKeyReleased(action: (KeyEvent) -> Unit) =
        onKeyReleased(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnKeyTyped(action: (KeyEvent) -> Unit) =
        onKeyTyped(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnInputMethodTextChanged(action: (InputMethodEvent) -> Unit) =
        onInputMethodTextChanged(Dispatchers.Unconfined) { action(it) }

    override fun Scene.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit) =
        onContextMenuRequested(Dispatchers.Unconfined) { action(it) }
}