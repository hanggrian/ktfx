package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.shape.PathElement

/**
 * Container of [Node].
 * Most subclasses of [javafx.scene.Parent] uses it.
 */
interface NodeManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param node child to add
     * @return the child added
     */
    fun <T : Node> addNode(node: T): T
}

/**
 * Container of [ToggleButton].
 * Used for `SegmentedButton.kt`.
 */
interface ToggleButtonManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param button child to add
     * @return the child added
     */
    fun <T : ToggleButton> addButton(button: T): T
}

/**
 * Container of [TitledPane].
 *
 * @see javafx.scene.control.Accordion
 */
interface TitledPaneManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param pane child to add
     * @return the child added
     */
    fun <T : TitledPane> addPane(pane: T): T
}

/**
 * Container of [Menu].
 *
 * @see javafx.scene.control.MenuBar
 */
interface MenuManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param menu child to add
     * @return the child added
     */
    fun <T : Menu> addMenu(menu: T): T
}

/**
 * Container of [MenuItem].
 *
 * @see javafx.scene.control.ContextMenu
 * @see javafx.scene.control.Menu
 * @see javafx.scene.control.MenuButton
 * @see javafx.scene.control.SplitMenuButton
 */
interface MenuItemManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param item child to add
     * @return the child added
     */
    fun <T : MenuItem> addItem(item: T): T
}

/**
 * Container of [Tab].
 * Also being used in `JFXTabPane.kt`.
 *
 * @see javafx.scene.control.TabPane
 */
interface TabManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param tab child to add
     * @return the child added
     */
    fun <T : Tab> addTab(tab: T): T
}

/**
 * Container of [PathElement].
 *
 * @see javafx.scene.shape.Path
 */
interface PathElementManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param element child to add
     * @return the child added
     */
    fun <T : PathElement> addElement(element: T): T
}
