package ktfx.layouts

import ktfx.application.initToolkit
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(JUnitPlatform::class)
object GridConstraintsSpec : Spek({

    given("A constrainted GridPane") {
        initToolkit()
        val gridPane = gridPane {
            row {
                constraints()
                constraints(20)
            }
            column {
                constraints(30)
                constraints()
            }
        }
        it("should have correct constraints") {
            assertNotNull(gridPane.rowConstraints[0])
            assertEquals(gridPane.rowConstraints[1].prefHeight, 20.0)
            assertEquals(gridPane.columnConstraints[0].prefWidth, 30.0)
            assertNotNull(gridPane.columnConstraints[1])
        }
    }
})