package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXPasswordField
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest

class JFXPasswordFieldTest : LayoutTest<NodeManager, JFXPasswordField>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxPasswordField { }
    override fun NodeManager.child2() = jfxPasswordField()
    override fun NodeManager.child3() = jfxPasswordField { }
}