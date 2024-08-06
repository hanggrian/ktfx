package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXDrawer
import ktfx.layouts.KtfxPane

class JfxDrawerTest : LayoutsTest<KtfxPane, JFXDrawer>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXDrawer = jfxDrawer { }

    override fun KtfxPane.child2(): JFXDrawer = jfxDrawer()

    override fun KtfxPane.child3(): JFXDrawer = jfxDrawer { }
}
