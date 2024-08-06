package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXBadge
import ktfx.layouts.KtfxPane

class JfxBadgeTest : LayoutsTest<KtfxPane, JFXBadge>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXBadge = jfxBadge { }

    override fun KtfxPane.child2(): JFXBadge = jfxBadge()

    override fun KtfxPane.child3(): JFXBadge = jfxBadge { }
}
