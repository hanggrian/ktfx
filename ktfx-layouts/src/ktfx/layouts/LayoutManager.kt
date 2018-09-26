package ktfx.layouts

import ktfx.internal.Internals

/** Base interface for all layout managers. */
interface LayoutManager<T> {

    /**
     * Should return the actual collection of this layout.
     *
     * @see javafx.scene.Parent.getChildren
     * @see javafx.scene.control.Accordion.getPanes
     * @see javafx.scene.control.ButtonBar.getButtons
     * @see javafx.scene.control.Menu.getItems
     * @see javafx.scene.control.MenuBar.getMenus
     * @see javafx.scene.control.TabPane.getTabs
     */
    val childs: MutableCollection<T> get() = Internals.fail { "Childs has not yet been initialized." }

    /** Add child, returning the child added. */
    operator fun <R : T> R.invoke(): R = also { childs += it }
}