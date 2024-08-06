package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXNodesList
import ktfx.layouts.KtfxPane

class JfxNodesListTest : LayoutsTest<KtfxPane, JFXNodesList>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXNodesList = jfxNodesList { }

    override fun KtfxPane.child2(): JFXNodesList = jfxNodesList()

    override fun KtfxPane.child3(): JFXNodesList = jfxNodesList { }
}
