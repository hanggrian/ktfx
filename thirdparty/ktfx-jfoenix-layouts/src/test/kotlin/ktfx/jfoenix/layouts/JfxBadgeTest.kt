package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXBadge
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import kotlin.test.Test
import kotlin.test.assertIs

class JfxBadgeTest : LayoutsStyledTest<KtfxPane, JFXBadge>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxBadge {}

    override fun KtfxPane.child2() = jfxBadge()

    override fun child3() = styledJfxBadge()

    override fun KtfxPane.child4() = styledJfxBadge()

    @Test
    fun add() {
        jfxBadge {
            region()
            assertIs<Region>(control)
        }
    }
}
