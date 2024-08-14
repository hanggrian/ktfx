package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXDrawer
import ktfx.layouts.KtfxPane

class JfxDrawerTest : LayoutsStyledTest<KtfxPane, JFXDrawer>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxDrawer {}

    override fun KtfxPane.child2() = jfxDrawer()

    override fun child3() = styledJfxDrawer(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxDrawer(styleClass = arrayOf("style"))
}
