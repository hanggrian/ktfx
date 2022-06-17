package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class JFXTogglePaneTest : LayoutsTest<KtfxPane, JFXTogglePane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxTogglePane { }
    override fun KtfxPane.child2() = jfxTogglePane()
    override fun KtfxPane.child3() = jfxTogglePane { }
}
