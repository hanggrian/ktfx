package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.layout.HBox
import kotlin.test.assertEquals

class HBoxTest : LayoutsTest<KtfxPane, HBox>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): HBox = hbox { }

    override fun KtfxPane.child2(): HBox = hbox()

    override fun KtfxPane.child3(): HBox = hbox { }

    override fun HBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
