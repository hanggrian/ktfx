@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.popups

import javafx.collections.ObservableList
import javafx.scene.control.MenuItem

interface PopupManager {

    /** Shadowed when being implemented in [javafx.scene.control.ContextMenu]. */
    fun getItems(): ObservableList<MenuItem>

    /** Convenient method to add child to this [javafx.scene.control.ContextMenu]. */
    fun <M : MenuItem> M.add(): M = apply { getItems().add(this) }
}