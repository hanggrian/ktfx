package ktfx.styles.scene.control

import javafx.scene.control.TableView
import ktfx.collections.observableListOf
import ktfx.styles.NodeTest
import ktfx.styles.tableViewStyle

class TableViewStyleTest : NodeTest<TableView<String>>() {

    override fun newInstance() = TableView<String>(observableListOf("Hello", "world"))

    override val style: String
        get() = tableViewStyle(true) {
            size = 50
        }

    override fun TableView<String>.assertion() {
    }
}