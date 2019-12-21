package ktfx.coroutines

import javafx.scene.Node
import javafx.scene.input.ContextMenuEvent
import javafx.scene.input.MouseEvent
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseNodeTest

class NodeTest : BaseNodeTest() {

    override fun Node.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit) =
        onContextMenuRequested(Dispatchers.Unconfined) { action(it) }

    override fun Node.callOnDragDetected(action: (MouseEvent) -> Unit) =
        onDragDetected(Dispatchers.Unconfined) { action(it) }
}