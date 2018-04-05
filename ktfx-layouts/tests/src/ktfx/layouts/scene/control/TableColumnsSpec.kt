package ktfx.layouts.scene.control

import ktfx.application.initToolkit
import ktfx.layouts.Person
import ktfx.layouts.column
import ktfx.layouts.columns
import ktfx.layouts.tableView
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object TableColumnsSpec : Spek({

    given("A TableView with columns") {
        initToolkit()
        val tableView = tableView<Person> {
            columns {
                column<String>("Name")
                column<Int>("Age")
            }
        }
        it("should have correct constraints") {
            assertEquals(tableView.columns[0].text, "Name")
            assertEquals(tableView.columns[1].text, "Age")
        }
    }
})