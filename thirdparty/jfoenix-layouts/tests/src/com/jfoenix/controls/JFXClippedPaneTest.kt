package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class JFXClippedPaneTest : LayoutsTest<KtfxPane, JFXClippedPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxClippedPane { }
    override fun KtfxPane.child2() = jfxClippedPane()
    override fun KtfxPane.child3() = jfxClippedPane { }
}