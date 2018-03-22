package ktfx.styles.scene.control

import javafx.scene.control.MenuBar
import ktfx.styles.NodeTest
import ktfx.styles.menuBarStyle
import kotlin.test.assertEquals

class MenuBarStyleTest : NodeTest<MenuBar>() {

    override fun newInstance() = MenuBar()

    override val style: String
        get() = menuBarStyle {
            // useSystemMenuBar = true
        }

    override fun MenuBar.assertion() {
        // assertEquals(isUseSystemMenuBar, true)
    }
}