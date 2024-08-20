package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.text.Text
import kotlin.test.assertEquals

class TextTest : LayoutsStyledTest<KtfxTextFlow, Text>() {
    override fun manager() = KtfxTextFlow()

    override fun KtfxTextFlow.childCount() = children.size

    override fun child1() = text {}

    override fun KtfxTextFlow.child2() = text()

    override fun child3() = styledText()

    override fun KtfxTextFlow.child4() = styledText()

    override fun Text.testDefaultValues() {
        assertEquals("", text)
    }
}
