package ktfx.coroutines

import javafx.scene.Node
import javafx.scene.input.ContextMenuEvent
import javafx.scene.input.DragEvent
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseDragEvent
import javafx.scene.input.MouseEvent
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseNodeTest

class NodeTest : BaseNodeTest() {

    override fun Node.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit) =
        onContextMenuRequested(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragDetected(action: (MouseEvent) -> Unit) =
        onDragDetected(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragDone(action: (DragEvent) -> Unit) =
        onDragDone(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragDropped(action: (DragEvent) -> Unit) =
        onDragDropped(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragEntered(action: (DragEvent) -> Unit) =
        onDragEntered(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragExited(action: (DragEvent) -> Unit) =
        onDragExited(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragOver(action: (DragEvent) -> Unit) =
        onDragOver(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnInputMethodTextChanged(action: (InputMethodEvent) -> Unit) =
        onInputMethodTextChanged(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnKeyPressed(action: (KeyEvent) -> Unit) =
        onKeyPressed(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnKeyReleased(action: (KeyEvent) -> Unit) =
        onKeyReleased(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnKeyTyped(action: (KeyEvent) -> Unit) =
        onKeyTyped(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseClicked(action: (MouseEvent) -> Unit) =
        onMouseClicked(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseDragEntered(action: (MouseDragEvent) -> Unit) =
        onMouseDragEntered(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnMouseDragExited(action: (MouseDragEvent) -> Unit) =
        onMouseDragExited(Dispatchers.Unconfined) { action(it) }
}