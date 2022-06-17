package ktfx.coroutines

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
import kotlinx.coroutines.Dispatchers
import com.hendraanggrian.ktfx.test.BaseNodeTest

class NodeTest : BaseNodeTest() {

    override fun Node.callOnDragEntered(action: (DragEvent) -> Unit) =
        onDragEntered(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragExited(action: (DragEvent) -> Unit) =
        onDragExited(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragOver(action: (DragEvent) -> Unit) =
        onDragOver(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragDropped(action: (DragEvent) -> Unit) =
        onDragDropped(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragDone(action: (DragEvent) -> Unit) =
        onDragDone(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit) =
        onContextMenuRequested(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseClicked(action: (MouseEvent) -> Unit) =
        onMouseClicked(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseDragged(action: (MouseEvent) -> Unit) =
        onMouseDragged(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseEntered(action: (MouseEvent) -> Unit) =
        onMouseEntered(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseExited(action: (MouseEvent) -> Unit) =
        onMouseExited(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseMoved(action: (MouseEvent) -> Unit) =
        onMouseMoved(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMousePressed(action: (MouseEvent) -> Unit) =
        onMousePressed(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseReleased(action: (MouseEvent) -> Unit) =
        onMouseReleased(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragDetected(action: (MouseEvent) -> Unit) =
        onDragDetected(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseDragOver(action: (MouseDragEvent) -> Unit) =
        onMouseDragOver(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseDragReleased(action: (MouseDragEvent) -> Unit) =
        onMouseDragReleased(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseDragEntered(action: (MouseDragEvent) -> Unit) =
        onMouseDragEntered(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseDragExited(action: (MouseDragEvent) -> Unit) =
        onMouseDragExited(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnScrollStarted(action: (ScrollEvent) -> Unit) =
        onScrollStarted(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnScroll(action: (ScrollEvent) -> Unit) =
        onScroll(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnScrollFinished(action: (ScrollEvent) -> Unit) =
        onScrollFinished(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnRotationStarted(action: (RotateEvent) -> Unit) =
        onRotationStarted(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnRotate(action: (RotateEvent) -> Unit) =
        onRotate(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnRotationFinished(action: (RotateEvent) -> Unit) =
        onRotationFinished(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnZoomStarted(action: (ZoomEvent) -> Unit) =
        onZoomStarted(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnZoom(action: (ZoomEvent) -> Unit) =
        onZoom(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnZoomFinished(action: (ZoomEvent) -> Unit) =
        onZoomFinished(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnSwipeUp(action: (SwipeEvent) -> Unit) =
        onSwipeUp(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnSwipeDown(action: (SwipeEvent) -> Unit) =
        onSwipeDown(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnSwipeRight(action: (SwipeEvent) -> Unit) =
        onSwipeRight(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnSwipeLeft(action: (SwipeEvent) -> Unit) =
        onSwipeLeft(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnTouchPressed(action: (TouchEvent) -> Unit) =
        onTouchPressed(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnTouchMoved(action: (TouchEvent) -> Unit) =
        onTouchMoved(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnTouchReleased(action: (TouchEvent) -> Unit) =
        onTouchReleased(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnTouchStationary(action: (TouchEvent) -> Unit) =
        onTouchStationary(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnKeyPressed(action: (KeyEvent) -> Unit) =
        onKeyPressed(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnKeyReleased(action: (KeyEvent) -> Unit) =
        onKeyReleased(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnKeyTyped(action: (KeyEvent) -> Unit) =
        onKeyTyped(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnInputMethodTextChanged(action: (InputMethodEvent) -> Unit) =
        onInputMethodTextChanged(Dispatchers.Unconfined) { action(it) }
}
