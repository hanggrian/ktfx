package ktfx

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import ktfx.internal.KtfxInternals
import ktfx.internal.KtfxManager

interface NodeManager : KtfxManager<Node> {

    val children: MutableCollection<Node> get() = KtfxInternals.fail()

    override operator fun <T : Node> T.invoke(): T = also { children += it }
}

interface TitledPaneManager : KtfxManager<TitledPane> {

    val panes: MutableCollection<TitledPane> get() = KtfxInternals.fail()

    override fun <R : TitledPane> R.invoke(): R = also { panes += it }
}

interface MenuItemManager : KtfxManager<MenuItem> {

    val items: MutableCollection<MenuItem> get() = KtfxInternals.fail()

    override fun <R : MenuItem> R.invoke(): R = also { items += it }
}

interface MenuManager : KtfxManager<Menu> {

    val menus: MutableCollection<Menu> get() = KtfxInternals.fail()

    override fun <R : Menu> R.invoke(): R = also { menus += it }
}

interface TabManager : KtfxManager<Tab> {

    val tabs: MutableCollection<Tab> get() = KtfxInternals.fail()

    override fun <R : Tab> R.invoke(): R = also { tabs += it }
}