package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXHamburger
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class JFXHamburgerTest : LayoutsTest<KtfxPane, JFXHamburger>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxHamburger { }
    override fun KtfxPane.child2() = jfxHamburger()
    override fun KtfxPane.child3() = jfxHamburger { }
}
