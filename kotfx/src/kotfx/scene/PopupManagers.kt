@file:JvmMultifileClass
@file:JvmName("ManagersKt")

package kotfx.scene

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ContextMenu
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem

interface PopupManager {

    fun getItems(): ObservableList<MenuItem>

    fun <T : MenuItem> T.add(): T = apply { getItems().add(this) }
}

class _Menu(text: String = "", graphic: Node? = null, vararg items: MenuItem) : Menu(text, graphic, *items), PopupManager

class _ContextMenu(vararg items: MenuItem) : ContextMenu(*items), PopupManager