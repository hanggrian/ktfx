package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXDrawersStack
import ktfx.layouts.KtfxPane

class JfxDrawersStackTest : LayoutsTest<KtfxPane, JFXDrawersStack>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXDrawersStack = jfxDrawersStack { }

    override fun KtfxPane.child2(): JFXDrawersStack = jfxDrawersStack()

    override fun KtfxPane.child3(): JFXDrawersStack = jfxDrawersStack { }
}
