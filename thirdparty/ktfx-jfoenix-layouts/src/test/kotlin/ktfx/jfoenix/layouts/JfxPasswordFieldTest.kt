package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXPasswordField
import ktfx.layouts.KtfxPane

class JfxPasswordFieldTest : LayoutsStyledTest<KtfxPane, JFXPasswordField>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxPasswordField {}

    override fun KtfxPane.child2() = jfxPasswordField()

    override fun child3() = styledJfxPasswordField()

    override fun KtfxPane.child4() = styledJfxPasswordField()
}
