package ktfx.layouts

import ktfx.application.initToolkit
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