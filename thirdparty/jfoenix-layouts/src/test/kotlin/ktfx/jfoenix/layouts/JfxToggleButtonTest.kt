package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXToggleButton
import ktfx.layouts.KtfxPane

class JfxToggleButtonTest : LayoutsTest<KtfxPane, JFXToggleButton>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXToggleButton = jfxToggleButton { }
    override fun KtfxPane.child2(): JFXToggleButton = jfxToggleButton()
    override fun KtfxPane.child3(): JFXToggleButton = jfxToggleButton { }
}
