package kotfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.Pane
import kotfx.internal.Instanced

@PublishedApi
abstract internal class FXPaneBuilder<out T : Pane> : PaneBuilder<T> {

    override val children: ObservableList<Node> get() = t.children
}

interface PaneBuilder<out T : Pane> : Instanced<T> {

    val children: ObservableList<Node>
}