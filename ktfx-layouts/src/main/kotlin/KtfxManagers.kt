package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.shape.PathElement

/**
 * A manager contains a set of children.
 *
 * @param C type of the child.
 */
interface Container<C> {
    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param child child to add.
     * @return the child added.
     */
    fun <T : C> addChild(child: T): T
}

/**
 * Container of [MenuItem].
 *
 * @see javafx.scene.control.ContextMenu
 * @see javafx.scene.control.Menu
 * @see javafx.scene.control.MenuButton
 * @see javafx.scene.control.SplitMenuButton
 */
interface MenuItemContainer : Container<MenuItem>

/**
 * Container of [Menu].
 *
 * @see javafx.scene.control.MenuBar
 */
interface MenuContainer : Container<Menu>

/** Container of [Node], being used in most subclasses of [javafx.scene.Parent]. */
interface NodeContainer : Container<Node>

/**
 * Container of [PathElement].
 *
 * @see javafx.scene.shape.Path
 */
interface PathElementContainer : Container<PathElement>

/**
 * Container of [Tab], also being used in `JFXTabPane.kt`.
 *
 * @see javafx.scene.control.TabPane
 */
interface TabContainer : Container<Tab>

/**
 * Container of [TitledPane].
 *
 * @see javafx.scene.control.Accordion
 */
interface TitledPaneContainer : Container<TitledPane>

/** Container of [ToggleButton], used for `SegmentedButton.kt`. */
interface ToggleButtonContainer : Container<ToggleButton>
