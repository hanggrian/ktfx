package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXRippler
import ktfx.layouts.KtfxPane

class JfxRipplerTest : LayoutsStyledTest<KtfxPane, JFXRippler>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxRippler {}

    override fun KtfxPane.child2() = jfxRippler()

    override fun child3() = styledJfxRippler(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxRippler(styleClass = arrayOf("style"))
}
