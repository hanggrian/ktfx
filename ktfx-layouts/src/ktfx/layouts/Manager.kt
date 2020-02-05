@file:UseExperimental(ExperimentalContracts::class)

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

/** Alias of [BaseManager.addChild] with [init] builder. */
inline fun <C : T, T> BaseManager<T>.addChild(child: C, init: C.() -> Unit): C {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    child.init()
    return addChild(child)
}

/**
 * A manager contains a set of children.
 * @param T type of the child.
 */
interface BaseManager<T> {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     * @param child child to add
     * @return the child added
     */
    fun <C : T> addChild(child: C): C

    /** Size of this manager. */
    val childCount: Int
}

/**
 * Container of [MenuItem].
 * @see javafx.scene.control.ContextMenu
 * @see javafx.scene.control.Menu
 * @see javafx.scene.control.MenuButton
 * @see javafx.scene.control.SplitMenuButton
 */
interface MenuItemManager : BaseManager<MenuItem>

/**
 * Container of [Menu].
 * @see javafx.scene.control.MenuBar
 */
interface MenuManager : BaseManager<Menu>

/** Container of [Node], being used in most subclasses of [javafx.scene.Parent]. */
interface NodeManager : BaseManager<Node>

/**
 * Container of [PathElement].
 * @see javafx.scene.shape.Path
 */
interface PathElementManager : BaseManager<PathElement>

/**
 * Container of [Tab].
 * Also being used in `JFXTabPane.kt`.
 * @see javafx.scene.control.TabPane
 */
interface TabManager : BaseManager<Tab>

/**
 * Container of [TitledPane].
 * @see javafx.scene.control.Accordion
 */
interface TitledPaneManager : BaseManager<TitledPane>

/**
 * Container of [ToggleButton].
 * Used for `SegmentedButton.kt`.
 */
interface ToggleButtonManager : BaseManager<ToggleButton>
