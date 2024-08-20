package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXDrawersStack
import ktfx.layouts.KtfxPane

class JfxDrawersStackTest : LayoutsStyledTest<KtfxPane, JFXDrawersStack>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxDrawersStack {}

    override fun KtfxPane.child2() = jfxDrawersStack()

    override fun child3() = styledJfxDrawersStack()

    override fun KtfxPane.child4() = styledJfxDrawersStack()
}
