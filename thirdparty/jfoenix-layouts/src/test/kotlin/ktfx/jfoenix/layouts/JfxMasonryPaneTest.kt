package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXMasonryPane
import ktfx.layouts.KtfxPane

class JfxMasonryPaneTest : LayoutsTest<KtfxPane, JFXMasonryPane>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXMasonryPane = jfxMasonryPane { }

    override fun KtfxPane.child2(): JFXMasonryPane = jfxMasonryPane()

    override fun KtfxPane.child3(): JFXMasonryPane = jfxMasonryPane { }
}
