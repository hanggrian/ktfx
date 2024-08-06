package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.layout.VBox
import kotlin.test.assertEquals

class VBoxTest : LayoutsTest<KtfxPane, VBox>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): VBox = vbox { }

    override fun KtfxPane.child2(): VBox = vbox()

    override fun KtfxPane.child3(): VBox = vbox { }

    override fun VBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
