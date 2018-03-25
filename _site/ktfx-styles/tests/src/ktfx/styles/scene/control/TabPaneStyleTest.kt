package ktfx.styles.scene.control

import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import ktfx.styles.NodeTest
import ktfx.styles.tabPaneStyle
import kotlin.test.assertEquals

class TabPaneStyleTest : NodeTest<TabPane>() {

    override fun newInstance() = TabPane(Tab("Hello"), Tab("world"))

    override val style: String
        get() = tabPaneStyle(true) {
            tabMinWidth = 50
            tabMaxWidth = 100
            tabMinHeight = 200
            tabMaxHeight = 300
        }

    override fun TabPane.assertion() {
        assertEquals(tabMinWidth, 50.0)
        assertEquals(tabMaxWidth, 100.0)
        assertEquals(tabMinHeight, 200.0)
        assertEquals(tabMaxHeight, 300.0)
    }
}