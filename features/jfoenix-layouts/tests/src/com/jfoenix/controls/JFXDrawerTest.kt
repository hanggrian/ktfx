package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest

class JFXDrawerTest : LayoutsTest<KtfxPane, JFXDrawer>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxDrawer { }
    override fun KtfxPane.child2() = jfxDrawer()
    override fun KtfxPane.child3() = jfxDrawer { }
}