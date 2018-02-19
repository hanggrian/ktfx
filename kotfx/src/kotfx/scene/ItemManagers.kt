package kotfx.scene

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ToolBar

interface ItemManager {

    fun getItems(): ObservableList<Node>

    fun <T : Node> T.add(): T = apply { getItems().add(this) }
}

class _ToolBar(vararg items: Node) : ToolBar(*items), ItemManager