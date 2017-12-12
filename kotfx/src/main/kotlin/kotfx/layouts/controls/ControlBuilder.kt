package kotfx.layouts.controls

import javafx.beans.property.ObjectProperty
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.Skin
import javafx.scene.control.Tooltip

interface ControlBuilder<out T : Control> : NodeBuilder<T> {

    val skinProperty: ObjectProperty<Skin<*>> get() = t.skinProperty()
    var skin: Skin<*>
        get() = t.skin
        set(value) = t.setSkin(value)

    val tooltipProperty: ObjectProperty<Tooltip> get() = t.tooltipProperty()
    var tooltip: Tooltip
        get() = t.tooltip
        set(value) = t.setTooltip(value)

    val contextMenuProperty: ObjectProperty<ContextMenu> get() = t.contextMenuProperty()
    var contextMenu: ContextMenu
        get() = t.contextMenu
        set(value) = t.setContextMenu(value)
}