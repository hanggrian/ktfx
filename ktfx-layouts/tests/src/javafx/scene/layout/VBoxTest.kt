package ktfx.layouts

import javafx.scene.layout.VBox
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class VBoxTest : LayoutsTest<KtfxPane, VBox>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = vbox { }
    override fun KtfxPane.child2() = vbox()
    override fun KtfxPane.child3() = vbox { }

    override fun VBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
