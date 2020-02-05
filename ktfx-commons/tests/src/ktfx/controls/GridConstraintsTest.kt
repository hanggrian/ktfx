package ktfx.controls

import javafx.scene.layout.GridPane
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GridConstraintsTest {

    @Test fun rowConstraints() {
        val gridPane = GridPane()
        gridPane.rowConstraints {
            constraints()
            constraints { isFillHeight = true }
        }
        assertEquals(2, gridPane.rowConstraints.size)
        assertTrue(gridPane.rowConstraints.last().isFillHeight)
    }

    @Test fun columnConstraints() {
        val gridPane = GridPane()
        gridPane.columnConstraints {
            constraints()
            constraints { prefWidth = 72.0 }
        }
        assertEquals(2, gridPane.columnConstraints.size)
        assertEquals(72.0, gridPane.columnConstraints.last().prefWidth)
    }
}