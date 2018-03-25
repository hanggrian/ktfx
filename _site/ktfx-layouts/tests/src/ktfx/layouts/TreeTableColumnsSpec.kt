package ktfx.layouts

import ktfx.application.initToolkit
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object TreeTableColumnsSpec : Spek({

    given("A TableView with columns") {
        initToolkit()
        val treeTableView = treeTableView<Person> {
            columns {
                column<String>("Name")
                column<Int>("Age")
            }
        }
        it("should have correct constraints") {
            assertEquals(treeTableView.columns[0].text, "Name")
            assertEquals(treeTableView.columns[1].text, "Age")
        }
    }
})