package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.Tab

/**
 * Manager for adding tabs with Kotlin DSL.
 */
interface TabManager : Manager<Tab> {

    /** Shall be shadowed on classes extending this interface. */
    fun getTabs(): ObservableList<Tab>

    override fun <T : Tab> T.add(): T = also { getTabs() += it }
}