package ktfx.text

import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFlowTest {

    @Test fun append() {
        assertEquals(
            "I have 3 little piggies",
            TextFlow().append("I have ").append(3).append(" little piggies").text
        )
        assertEquals(
            StringBuilder().append("Here is ")
                .append(null as String?)
                .append(" String and ")
                .append(null as Any?)
                .append(" Object").toString(),
            TextFlow().append("Here is ")
                .append(null as String?)
                .append(" String and ")
                .append(null as Any?)
                .append(" Object").text
        )
    }

    @Test fun appendln() {
        assertEquals(
            """
               A wolf just ate
               2
               of them
            """.trimIndent(),
            TextFlow().appendln("A wolf just ate").appendln(2).append("of them").text
        )
        assertEquals(
            StringBuilder().appendln("Here is ")
                .appendln(null as String?)
                .appendln(" String and ")
                .appendln(null as Any?)
                .appendln(" Object").toString(),
            TextFlow().appendln("Here is ")
                .appendln(null as String?)
                .appendln(" String and ")
                .appendln(null as Any?)
                .appendln(" Object").text
        )
    }

    private val TextFlow.text: String get() = children.joinToString("") { (it as Text).text }
}
