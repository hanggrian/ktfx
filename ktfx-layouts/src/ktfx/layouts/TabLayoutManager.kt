package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.Tab

/**
 * LayoutManager for adding tabs with Kotlin DSL.
 *
 * @see _TabPane
 */
interface TabLayoutManager : LayoutManager<Tab> {

    /** Shall be shadowed on classes extending this interface. */
    fun getTabs(): ObservableList<Tab>

    override fun <T : Tab> T.add(): T = also { getTabs() += it }
}