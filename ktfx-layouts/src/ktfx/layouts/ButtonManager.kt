package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node

interface ButtonManager {

    fun getButtons(): ObservableList<Node>

    fun <T : Node> T.add(): T = also { getButtons() += it }
}