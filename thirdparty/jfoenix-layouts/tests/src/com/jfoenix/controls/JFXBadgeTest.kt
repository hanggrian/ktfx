package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class JFXBadgeTest : LayoutsTest<KtfxPane, JFXBadge>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxBadge { }
    override fun KtfxPane.child2() = jfxBadge()
    override fun KtfxPane.child3() = jfxBadge { }
}