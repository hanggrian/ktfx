package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXTogglePane
import ktfx.layouts.KtfxPane

class JfxTogglePaneTest : LayoutsTest<KtfxPane, JFXTogglePane>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXTogglePane = jfxTogglePane { }

    override fun KtfxPane.child2(): JFXTogglePane = jfxTogglePane()

    override fun KtfxPane.child3(): JFXTogglePane = jfxTogglePane { }
}
