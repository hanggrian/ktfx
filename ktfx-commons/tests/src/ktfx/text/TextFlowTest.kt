package ktfx.text

import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFlowTest {

    @Test fun append() {
        val flow = TextFlow()
        flow.append("I").append("have").append(3).append("piggies")
        assertEquals(flow.children.joinToString(" ") { (it as Text).text }, "I have 3 piggies")
    }

    @Test fun appendln() {
        val flow = TextFlow()
        flow.appendln("Is this real?").appendln().append(true)
        assertEquals(
            flow.children.joinToString("") { (it as Text).text },
            """
               Is this real?
               
               true
            """.trimIndent()
        )
    }
}