package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXHamburger
import ktfx.layouts.KtfxPane

class JfxHamburgerTest : LayoutsTest<KtfxPane, JFXHamburger>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXHamburger = jfxHamburger { }
    override fun KtfxPane.child2(): JFXHamburger = jfxHamburger()
    override fun KtfxPane.child3(): JFXHamburger = jfxHamburger { }
}
