package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXPasswordField
import ktfx.layouts.KtfxPane

class JfxPasswordFieldTest : LayoutsTest<KtfxPane, JFXPasswordField>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXPasswordField = jfxPasswordField { }
    override fun KtfxPane.child2(): JFXPasswordField = jfxPasswordField()
    override fun KtfxPane.child3(): JFXPasswordField = jfxPasswordField { }
}
