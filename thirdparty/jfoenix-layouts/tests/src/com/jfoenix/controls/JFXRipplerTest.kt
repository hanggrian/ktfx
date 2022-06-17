package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class JFXRipplerTest : LayoutsTest<KtfxPane, JFXRippler>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxRippler { }
    override fun KtfxPane.child2() = jfxRippler()
    override fun KtfxPane.child3() = jfxRippler { }
}
