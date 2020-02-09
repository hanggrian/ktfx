package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest

class JFXNodesListTest : LayoutsTest<KtfxPane, JFXNodesList>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxNodesList { }
    override fun KtfxPane.child2() = jfxNodesList()
    override fun KtfxPane.child3() = jfxNodesList { }
}