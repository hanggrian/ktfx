package ktfx.text

import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFlowTest {
    @Test
    fun set() {
        val flow = TextFlow()
        flow.children += Text("Hello")
        flow[0] = "World"
        assertEquals("World", flow.text)
    }

    @Test
    fun clear() {
        val flow = TextFlow()
        flow.children += Text("Hello")
        flow.children += Text("World")
        flow.clear()
        assertEquals(0, flow.children.size)
    }

    @Test
    fun append() {
        assertEquals(
            "I have 3 little piggies",
            TextFlow().append("I have ").append(3).append(" little piggies").text,
        )
        assertEquals(
            StringBuilder()
                .append("Here is ")
                .append(null as String?)
                .append(" String and ")
                .append(null as Any?)
                .append(" Object")
                .toString(),
            TextFlow()
                .append("Here is ")
                .append(null as String?)
                .append(" String and ")
                .append(null as Any?)
                .append(" Object")
                .text,
        )
    }

    @Test
    fun appendLine() {
        assertEquals(
            """
            A wolf just ate
            2
            of them
            """.trimIndent(),
            TextFlow().appendLine("A wolf just ate").appendLine(2).append("of them").text,
        )
        assertEquals(
            StringBuilder()
                .appendLine("Here is ")
                .appendLine(null as String?)
                .appendLine(" String and ")
                .appendLine(null as Any?)
                .appendLine(" Object")
                .toString(),
            TextFlow()
                .appendLine("Here is ")
                .appendLine(null as String?)
                .appendLine(" String and ")
                .appendLine(null as Any?)
                .appendLine(" Object")
                .text,
        )
    }

    private val TextFlow.text: String get() = children.joinToString("") { (it as Text).text }
}
