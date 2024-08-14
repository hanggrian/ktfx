package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXHamburger
import ktfx.layouts.KtfxPane

class JfxHamburgerTest : LayoutsStyledTest<KtfxPane, JFXHamburger>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxHamburger {}

    override fun KtfxPane.child2() = jfxHamburger()

    override fun child3() = styledJfxHamburger(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxHamburger(styleClass = arrayOf("style"))
}
