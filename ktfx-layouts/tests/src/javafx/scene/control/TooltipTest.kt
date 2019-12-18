package ktfx.layouts

import javafx.scene.control.TableColumn
import javafx.util.Duration
import ktfx.test.ToolkitInitializer
import kotlin.test.Test
import kotlin.test.assertNotNull

class TooltipTest : ToolkitInitializer {

    @Test fun node() {
        imageView {
            tooltip()
        }
        imageView {
            tooltip { }
        }
    }

    @Test fun control() {
        button {
            tooltip()
            assertNotNull(tooltip)
        }
        button {
            tooltip { }
            assertNotNull(tooltip)
        }
    }

    @Test fun tab() {
        tab {
            tooltip()
            assertNotNull(tooltip)
        }
        tab {
            tooltip { }
            assertNotNull(tooltip)
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