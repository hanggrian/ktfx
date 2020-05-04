package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXMasonryPane
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class JFXMasonryPaneTest : LayoutsTest<KtfxPane, JFXMasonryPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxMasonryPane { }
    override fun KtfxPane.child2() = jfxMasonryPane()
    override fun KtfxPane.child3() = jfxMasonryPane { }
}