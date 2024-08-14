package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXNodesList
import ktfx.layouts.KtfxPane

class JfxNodesListTest : LayoutsStyledTest<KtfxPane, JFXNodesList>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxNodesList {}

    override fun KtfxPane.child2() = jfxNodesList()

    override fun child3() = styledJfxNodesList(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxNodesList(styleClass = arrayOf("style"))
}
