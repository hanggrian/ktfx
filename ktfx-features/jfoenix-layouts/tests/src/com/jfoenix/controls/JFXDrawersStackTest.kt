package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawersStack
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest

class JFXDrawersStackTest : BaseLayoutTest<NodeManager, JFXDrawersStack>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxDrawersStack { }
    override fun NodeManager.child2() = jfxDrawersStack()
    override fun NodeManager.child3() = jfxDrawersStack { }
}