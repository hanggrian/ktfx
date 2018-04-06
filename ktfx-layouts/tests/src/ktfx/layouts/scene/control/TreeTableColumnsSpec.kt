package ktfx.layouts.scene.control

import ktfx.application.initToolkit
import ktfx.layouts.Person
import ktfx.layouts.columns
import ktfx.layouts.treeTableView
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
                "Name"<String>()
                "Age"<Int>()
            }
        }
        it("should have correct constraints") {
            assertEquals(treeTableView.columns[0].text, "Name")
            assertEquals(treeTableView.columns[1].text, "Age")
        }
    }
})