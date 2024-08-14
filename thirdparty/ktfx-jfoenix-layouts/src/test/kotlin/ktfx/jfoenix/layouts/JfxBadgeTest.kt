package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXBadge
import ktfx.layouts.KtfxPane

class JfxBadgeTest : LayoutsStyledTest<KtfxPane, JFXBadge>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxBadge {}

    override fun KtfxPane.child2() = jfxBadge()

    override fun child3() = styledJfxBadge(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxBadge(styleClass = arrayOf("style"))
}
