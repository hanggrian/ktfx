package kotfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.Pane

interface PaneBuilder<out T : Pane> : RegionBuilder<T> {

    override val children: ObservableList<Node> get() = t.children
}