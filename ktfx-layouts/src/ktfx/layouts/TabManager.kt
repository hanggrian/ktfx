package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.Tab

interface TabManager {

    fun getTabs(): ObservableList<Tab>

    fun <T : Tab> T.add(): T = also { getTabs() += it }
}