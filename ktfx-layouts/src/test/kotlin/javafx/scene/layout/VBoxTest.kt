package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.VBox
import kotlin.test.assertEquals

class VBoxTest : LayoutsStyledTest<KtfxPane, VBox>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = vbox {}

    override fun KtfxPane.child2() = vbox()

    override fun child3() = styledVBox(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledVBox(styleClass = arrayOf("style"))

    override fun VBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
