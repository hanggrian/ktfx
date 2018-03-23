package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node

interface ItemManager {

    fun getItems(): ObservableList<Node>

    fun <T : Node> T.add(): T = also { getItems() += it }
}