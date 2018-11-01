package ktfx

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.shape.PathElement

/** Base interface for all layout managers. */
interface KtfxManager<T> {

    /**
     * Allows item to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @receiver the item to add
     * @return the item added
     */
    operator fun <R : T> R.invoke(): R
}

/** Manager for most panes. */
interface NodeManager : KtfxManager<Node>

/** Manager for [javafx.scene.control.Accordion]. */
interface TitledPaneManager : KtfxManager<TitledPane>

/** Manager for [javafx.scene.control.MenuBar]. */
interface MenuManager : KtfxManager<Menu>

/** Manager for [javafx.scene.control.SplitMenuButton]. */
interface MenuItemManager : KtfxManager<MenuItem>

/** Manager for [javafx.scene.control.TabPane]. */
interface TabManager : KtfxManager<Tab>

/** Manager for [javafx.scene.shape.Path]. */
interface PathElementManager : KtfxManager<PathElement>