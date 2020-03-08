package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.shape.PathElement
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Alias of [LayoutManager.addChild] with [configuration] builder. */
@OptIn(ExperimentalContracts::class)
inline fun <C : T, T> LayoutManager<T>.addChild(child: C, configuration: C.() -> Unit): C {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    child.configuration()
    return addChild(child)
}

/**
 * A manager contains a set of children.
 * @param T type of the child.
 */
interface LayoutManager<T> {

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
interface MenuItemManager : LayoutManager<MenuItem>

/**
 * Container of [Menu].
 * @see javafx.scene.control.MenuBar
 */
interface MenuManager : LayoutManager<Menu>

/** Container of [Node], being used in most subclasses of [javafx.scene.Parent]. */
interface NodeManager : LayoutManager<Node>

/**
 * Container of [PathElement].
 * @see javafx.scene.shape.Path
 */
interface PathElementManager : LayoutManager<PathElement>

/**
 * Container of [Tab].
 * Also being used in `JFXTabPane.kt`.
 * @see javafx.scene.control.TabPane
 */
interface TabManager : LayoutManager<Tab>

/**
 * Container of [TitledPane].
 * @see javafx.scene.control.Accordion
 */
interface TitledPaneManager : LayoutManager<TitledPane>

/**
 * Container of [ToggleButton].
 * Used for `SegmentedButton.kt`.
 */
interface ToggleButtonManager : LayoutManager<ToggleButton>
