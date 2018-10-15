package ktfx

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import ktfx.internal.KtfxInternals
import ktfx.internal.KtfxManager

interface NodeManager : KtfxManager<Node> {

    object InvokableOnly : NodeManager {
        override val collection: MutableCollection<Node> get() = KtfxInternals.fail()
    }
}

interface TitledPaneManager : KtfxManager<TitledPane>

interface MenuItemManager : KtfxManager<MenuItem>

interface MenuManager : KtfxManager<Menu>

interface TabManager : KtfxManager<Tab>