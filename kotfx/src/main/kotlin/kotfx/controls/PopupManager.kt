package kotfx

import javafx.collections.ObservableList
import javafx.scene.control.MenuItem

interface PopupManager {

    /** Shadowed when being implemented in [javafx.scene.control.ContextMenu]. */
    fun getItems(): ObservableList<MenuItem>

    /** Convenient method to add child to this [javafx.scene.control.ContextMenu]. */
    fun <T : MenuItem> T.add(): T = apply { getItems().add(this) }
}