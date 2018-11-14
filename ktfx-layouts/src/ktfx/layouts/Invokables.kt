package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.shape.PathElement

/** Base interface for all layout managers. */
interface KtfxInvokable<T> {

    /**
     * Allows item to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @receiver the item to add
     * @return the item added
     */
    operator fun <R : T> R.invoke(): R
}

/** Manager for most panes. */
interface NodeInvokable : KtfxInvokable<Node>

/** Manager for ControlsFX segmented button. */
interface ToggleButtonInvokable : KtfxInvokable<ToggleButton>

/** Manager for [javafx.scene.control.Accordion]. */
interface TitledPaneInvokable : KtfxInvokable<TitledPane>

/** Manager for [javafx.scene.control.MenuBar]. */
interface MenuInvokable : KtfxInvokable<Menu>

/** Manager for [javafx.scene.control.SplitMenuButton]. */
interface MenuItemInvokable : KtfxInvokable<MenuItem>

/** Manager for [javafx.scene.control.TabPane]. */
interface TabInvokable : KtfxInvokable<Tab>

/** Manager for [javafx.scene.shape.Path]. */
interface PathElementInvokable : KtfxInvokable<PathElement>