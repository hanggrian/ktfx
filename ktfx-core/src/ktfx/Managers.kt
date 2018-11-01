package ktfx

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.shape.PathElement
import ktfx.internal.KtfxInternals

/** Base interface for all layout managers. */
interface KtfxManager<T> {

    /** Actual collection that this manager holds. */
    val collection: MutableCollection<T>

    /**
     * Allows item to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @receiver the item to add
     * @return the item added
     */
    operator fun <R : T> R.invoke(): R = also { collection += it }

    companion object {

        /** Implementation of manager where collection are newly created empty modifiable list. */
        fun <T> empty(): KtfxManager<T> = object : KtfxManager<T> {
            override val collection: MutableCollection<T> = mutableListOf()
        }
    }
}

/** Manager for most panes. */
interface NodeManager : KtfxManager<Node> {

    companion object {

        private val invokableOnly = object : NodeManager {
            override val collection: MutableCollection<Node>
                get() = KtfxInternals.fail {
                    "This manager has no children, because it is intended to be invokable only."
                }
        }

        /** Managers delegated by this object must override `invoke` to avoid unsupported error operation. */
        fun invokableOnly(): NodeManager = invokableOnly

        /** Implementation of manager where collection are newly created empty modifiable list. */
        fun empty(): NodeManager = object : NodeManager {
            override val collection: MutableCollection<Node> = mutableListOf()
        }
    }
}

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