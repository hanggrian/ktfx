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
import com.hendraanggrian.ktfx.test.BaseNodeTest

class NodeTest : BaseNodeTest() {

    override fun Node.callOnDragEntered(action: (DragEvent) -> Unit) = onDragEntered(action)
    override fun Node.callOnDragExited(action: (DragEvent) -> Unit) = onDragExited(action)
    override fun Node.callOnDragOver(action: (DragEvent) -> Unit) = onDragOver(action)
    override fun Node.callOnDragDropped(action: (DragEvent) -> Unit) = onDragDropped(action)
    override fun Node.callOnDragDone(action: (DragEvent) -> Unit) = onDragDone(action)
    override fun Node.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit) = onContextMenuRequested(action)
    override fun Node.callOnMouseClicked(action: (MouseEvent) -> Unit) = onMouseClicked(action)
    override fun Node.callOnMouseDragged(action: (MouseEvent) -> Unit) = onMouseDragged(action)
    override fun Node.callOnMouseEntered(action: (MouseEvent) -> Unit) = onMouseEntered(action)
    override fun Node.callOnMouseExited(action: (MouseEvent) -> Unit) = onMouseExited(action)
    override fun Node.callOnMouseMoved(action: (MouseEvent) -> Unit) = onMouseMoved(action)
    override fun Node.callOnMousePressed(action: (MouseEvent) -> Unit) = onMousePressed(action)
    override fun Node.callOnMouseReleased(action: (MouseEvent) -> Unit) = onMouseReleased(action)
    override fun Node.callOnDragDetected(action: (MouseEvent) -> Unit) = onDragDetected(action)
    override fun Node.callOnMouseDragOver(action: (MouseDragEvent) -> Unit) = onMouseDragOver(action)
    override fun Node.callOnMouseDragReleased(action: (MouseDragEvent) -> Unit) = onMouseDragReleased(action)
    override fun Node.callOnMouseDragEntered(action: (MouseDragEvent) -> Unit) = onMouseDragEntered(action)
    override fun Node.callOnMouseDragExited(action: (MouseDragEvent) -> Unit) = onMouseDragExited(action)
    override fun Node.callOnScrollStarted(action: (ScrollEvent) -> Unit) = onScrollStarted(action)
    override fun Node.callOnScroll(action: (ScrollEvent) -> Unit) = onScroll(action)
    override fun Node.callOnScrollFinished(action: (ScrollEvent) -> Unit) = onScrollFinished(action)
    override fun Node.callOnRotationStarted(action: (RotateEvent) -> Unit) = onRotationStarted(action)
    override fun Node.callOnRotate(action: (RotateEvent) -> Unit) = onRotate(action)
    override fun Node.callOnRotationFinished(action: (RotateEvent) -> Unit) = onRotationFinished(action)
    override fun Node.callOnZoomStarted(action: (ZoomEvent) -> Unit) = onZoomStarted(action)
    override fun Node.callOnZoom(action: (ZoomEvent) -> Unit) = onZoom(action)
    override fun Node.callOnZoomFinished(action: (ZoomEvent) -> Unit) = onZoomFinished(action)
    override fun Node.callOnSwipeUp(action: (SwipeEvent) -> Unit) = onSwipeUp(action)
    override fun Node.callOnSwipeDown(action: (SwipeEvent) -> Unit) = onSwipeDown(action)
    override fun Node.callOnSwipeRight(action: (SwipeEvent) -> Unit) = onSwipeRight(action)
    override fun Node.callOnSwipeLeft(action: (SwipeEvent) -> Unit) = onSwipeLeft(action)
    override fun Node.callOnTouchPressed(action: (TouchEvent) -> Unit) = onTouchPressed(action)
    override fun Node.callOnTouchMoved(action: (TouchEvent) -> Unit) = onTouchMoved(action)
    override fun Node.callOnTouchReleased(action: (TouchEvent) -> Unit) = onTouchReleased(action)
    override fun Node.callOnTouchStationary(action: (TouchEvent) -> Unit) = onTouchStationary(action)
    override fun Node.callOnKeyPressed(action: (KeyEvent) -> Unit) = onKeyPressed(action)
    override fun Node.callOnKeyReleased(action: (KeyEvent) -> Unit) = onKeyReleased(action)
    override fun Node.callOnKeyTyped(action: (KeyEvent) -> Unit) = onKeyTyped(action)
    override fun Node.callOnInputMethodTextChanged(action: (InputMethodEvent) -> Unit) =
        onInputMethodTextChanged(action)
}