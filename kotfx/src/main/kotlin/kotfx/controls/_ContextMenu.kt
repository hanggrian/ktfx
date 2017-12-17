package kotfx.controls

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import kotfx.internal.PopupManager

class _ContextMenu(vararg items: MenuItem) : ContextMenu(*items), PopupManager