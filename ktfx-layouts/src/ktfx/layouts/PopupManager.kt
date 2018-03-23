package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.MenuItem

interface PopupManager {

    fun getItems(): ObservableList<MenuItem>

    fun <T : MenuItem> T.add(): T = also { getItems() += it }
}