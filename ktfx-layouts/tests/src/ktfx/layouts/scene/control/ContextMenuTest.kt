package ktfx.layouts.scene.control

import javafx.scene.control.TableColumn
import javafx.util.Duration
import ktfx.layouts.button
import ktfx.layouts.contextMenu
import ktfx.layouts.menuItem
import ktfx.layouts.tab
import ktfx.test.ToolkitInitializer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ContextMenuTest : ToolkitInitializer {

    @Test fun stringInvocation() {
        contextMenu {
            menuItem("Hello")
            "World" {
            }
            assertEquals(2, items.size)
        }
    }

    @Test fun control() {
        button {
            contextMenu()
            assertNotNull(contextMenu)
        }
        button {
            contextMenu { }
            assertNotNull(contextMenu)
        }
    }

    @Test fun tab() {
        tab {
            contextMenu()
            assertNotNull(contextMenu)
        }
        tab {
            contextMenu { }
            assertNotNull(contextMenu)
        }
    }

    @Test fun tableColumn() {
        val column1 = TableColumn<Duration, String>()
        column1.contextMenu()
        assertNotNull(column1.contextMenu)
        val column2 = TableColumn<Duration, String>()
        column2.contextMenu()
        assertNotNull(column2.contextMenu)
    }
}