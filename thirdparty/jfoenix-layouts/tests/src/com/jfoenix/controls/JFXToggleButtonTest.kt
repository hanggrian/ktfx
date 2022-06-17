package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleButton
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class JFXToggleButtonTest : LayoutsTest<KtfxPane, JFXToggleButton>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxToggleButton { }
    override fun KtfxPane.child2() = jfxToggleButton()
    override fun KtfxPane.child3() = jfxToggleButton { }
}
