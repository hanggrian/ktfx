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
 * @param T type of the child.
 */
interface KtfxManager<T> {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     * @param child child to add
     * @return the child added
     */
    fun <C : T> addChild(child: C): C
}

/**
 * Container of [MenuItem].
 * @see javafx.scene.control.ContextMenu
 * @see javafx.scene.control.Menu
 * @see javafx.scene.control.MenuButton
 * @see javafx.scene.control.SplitMenuButton
 */
interface MenuItemManager : KtfxManager<MenuItem>

/**
 * Container of [Menu].
 * @see javafx.scene.control.MenuBar
 */
interface MenuManager : KtfxManager<Menu>

/** Container of [Node], being used in most subclasses of [javafx.scene.Parent]. */
interface NodeManager : KtfxManager<Node>

/**
 * Container of [PathElement].
 * @see javafx.scene.shape.Path
 */
interface PathElementManager : KtfxManager<PathElement>

/**
 * Container of [Tab].
 * Also being used in `JFXTabPane.kt`.
 * @see javafx.scene.control.TabPane
 */
interface TabManager : KtfxManager<Tab>

/**
 * Container of [TitledPane].
 * @see javafx.scene.control.Accordion
 */
interface TitledPaneManager : KtfxManager<TitledPane>

/**
 * Container of [ToggleButton].
 * Used for `SegmentedButton.kt`.
 */
interface ToggleButtonManager : KtfxManager<ToggleButton>
