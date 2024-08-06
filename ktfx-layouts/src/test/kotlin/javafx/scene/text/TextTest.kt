package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.text.Text
import kotlin.test.assertEquals

class TextTest : LayoutsTest<KtfxTextFlow, Text>() {
    override fun manager(): KtfxTextFlow = KtfxTextFlow()

    override fun KtfxTextFlow.childCount(): Int = children.size

    override fun child1(): Text = text { }

    override fun KtfxTextFlow.child2(): Text = text()

    override fun KtfxTextFlow.child3(): Text = text { }

    override fun Text.testDefaultValues() {
        assertEquals("", text)
    }
}
