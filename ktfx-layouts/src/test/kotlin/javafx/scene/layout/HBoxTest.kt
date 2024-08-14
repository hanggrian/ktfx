package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.HBox
import kotlin.test.assertEquals

class HBoxTest : LayoutsStyledTest<KtfxPane, HBox>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = hbox {}

    override fun KtfxPane.child2() = hbox()

    override fun child3() = styledHBox(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledHBox(styleClass = arrayOf("style"))

    override fun HBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
