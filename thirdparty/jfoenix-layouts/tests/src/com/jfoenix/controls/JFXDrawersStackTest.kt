package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawersStack
import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class JFXDrawersStackTest : LayoutsTest<KtfxPane, JFXDrawersStack>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxDrawersStack { }
    override fun KtfxPane.child2() = jfxDrawersStack()
    override fun KtfxPane.child3() = jfxDrawersStack { }
}