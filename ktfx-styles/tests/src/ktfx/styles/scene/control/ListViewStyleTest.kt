package ktfx.styles.scene.control

import javafx.geometry.Orientation.VERTICAL
import javafx.scene.control.ListView
import ktfx.collections.observableListOf
import ktfx.styles.NodeTest
import ktfx.styles.listViewStyle
import kotlin.test.assertEquals

class ListViewStyleTest : NodeTest<ListView<String>>() {

    override fun newInstance() = ListView<String>(observableListOf("Hello", "world"))

    override val style: String
        get() = listViewStyle {
            orientation = VERTICAL
        }

    override fun ListView<String>.assertion() {
        assertEquals(orientation, VERTICAL)
    }
}