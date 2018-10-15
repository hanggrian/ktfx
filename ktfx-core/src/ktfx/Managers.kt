package ktfx

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import ktfx.internal.KtfxInternals
import ktfx.internal.KtfxManager

interface NodeManager : KtfxManager<Node> {

    fun getChildren(): MutableList<Node>

    override operator fun <T : Node> T.invoke(): T = also { getChildren() += it }

    object InvokableOnly : NodeManager {
        override fun getChildren(): ObservableList<Node> = KtfxInternals.fail()
    }
}

interface TitledPaneManager : KtfxManager<TitledPane> {

    fun getPanes(): MutableList<TitledPane>

    override fun <R : TitledPane> R.invoke(): R = also { getPanes() += it }
}

interface MenuItemManager : KtfxManager<MenuItem> {

    fun getItems(): MutableList<MenuItem>

    override fun <R : MenuItem> R.invoke(): R = also { getItems() += it }
}

interface MenuManager : KtfxManager<Menu> {

    fun getMenus(): MutableList<Menu>

    override fun <R : Menu> R.invoke(): R = also { getMenus() += it }
}

interface TabManager : KtfxManager<Tab> {

    fun getTabs(): MutableList<Tab>

    override fun <R : Tab> R.invoke(): R = also { getTabs() += it }
}