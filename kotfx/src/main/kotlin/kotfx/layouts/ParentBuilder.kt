package kotfx.layouts

import javafx.beans.property.ReadOnlyBooleanProperty
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.Parent
import kotfx.layouts.controls.NodeBuilder

interface ParentBuilder<out T : Parent> : NodeBuilder<T> {

    val children: ObservableList<Node> get() = t.childrenUnmodifiable

    val needsLayoutProperty: ReadOnlyBooleanProperty get() = t.needsLayoutProperty()
    val needsLayout: Boolean get() = t.isNeedsLayout

    fun requestLayout() = t.requestLayout()
    fun layout() = t.layout()
}