package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXButton
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxButtonTest : LayoutsTest<KtfxPane, JFXButton>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXButton = jfxButton { }

    override fun KtfxPane.child2(): JFXButton = jfxButton()

    override fun KtfxPane.child3(): JFXButton = jfxButton { }

    override fun JFXButton.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
