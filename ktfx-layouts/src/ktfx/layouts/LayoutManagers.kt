package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.shape.PathElement

/**
 * Base interface for all layout managers.
 *
 * @param T child of this parent
 */
interface LayoutManager<T> {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @receiver the child to add
     * @return the child added
     */
    fun <R : T> R.add(): R
}

/** Manager for most panes. */
interface NodeManager : LayoutManager<Node>

/** Manager for ControlsFX segmented button. */
interface ToggleButtonManager : LayoutManager<ToggleButton>

/** Manager for [javafx.scene.control.Accordion]. */
interface TitledPaneManager : LayoutManager<TitledPane>

/** Manager for [javafx.scene.control.MenuBar]. */
interface MenuManager : LayoutManager<Menu>

/** Manager for [javafx.scene.control.SplitMenuButton]. */
interface MenuItemManager : LayoutManager<MenuItem>

/** Manager for [javafx.scene.control.TabPane]. */
interface TabManager : LayoutManager<Tab>

/** Manager for [javafx.scene.shape.Path]. */
interface PathElementManager : LayoutManager<PathElement>