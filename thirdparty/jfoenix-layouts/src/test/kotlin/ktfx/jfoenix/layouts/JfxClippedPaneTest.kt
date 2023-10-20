package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXClippedPane
import ktfx.layouts.KtfxPane

class JfxClippedPaneTest : LayoutsTest<KtfxPane, JFXClippedPane>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXClippedPane = jfxClippedPane { }

    override fun KtfxPane.child2(): JFXClippedPane = jfxClippedPane()

    override fun KtfxPane.child3(): JFXClippedPane = jfxClippedPane { }
}
