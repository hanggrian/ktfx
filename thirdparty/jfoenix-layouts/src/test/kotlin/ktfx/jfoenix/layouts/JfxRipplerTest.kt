package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXRippler
import ktfx.layouts.KtfxPane

class JfxRipplerTest : LayoutsTest<KtfxPane, JFXRippler>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXRippler = jfxRippler { }
    override fun KtfxPane.child2(): JFXRippler = jfxRippler()
    override fun KtfxPane.child3(): JFXRippler = jfxRippler { }
}
