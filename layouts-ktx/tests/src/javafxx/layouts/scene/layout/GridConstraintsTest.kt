package javafxx.layouts.scene.layout

import javafxx.layouts.columnConstraints
import javafxx.layouts.gridPane
import javafxx.layouts.rowConstraints
import javafxx.test.PlatformTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GridConstraintsTest : PlatformTest() {

    @Test fun constraints() {
        val gridPane = gridPane {
            rowConstraints {
                constraints()
                constraints(20.0)
            }
            columnConstraints {
                constraints(30.0)
                constraints()
            }
        }
        assertNotNull(gridPane.rowConstraints[0])
        assertEquals(gridPane.rowConstraints[1].prefHeight, 20.0)
        assertEquals(gridPane.columnConstraints[0].prefWidth, 30.0)
        assertNotNull(gridPane.columnConstraints[1])
    }
}