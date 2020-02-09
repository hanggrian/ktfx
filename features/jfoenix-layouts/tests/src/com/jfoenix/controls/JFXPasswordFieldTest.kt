package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXPasswordField
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest

class JFXPasswordFieldTest : LayoutsTest<KtfxPane, JFXPasswordField>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxPasswordField { }
    override fun KtfxPane.child2() = jfxPasswordField()
    override fun KtfxPane.child3() = jfxPasswordField { }
}