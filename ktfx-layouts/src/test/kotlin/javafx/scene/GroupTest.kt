package javafx.scene

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.group
import ktfx.layouts.region
import ktfx.layouts.styledGroup
import kotlin.test.Test
import kotlin.test.assertIs

class GroupTest : LayoutsStyledTest<KtfxPane, Group>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = group {}

    override fun KtfxPane.child2() = group()

    override fun child3() = styledGroup()

    override fun KtfxPane.child4() = styledGroup()

    @Test
    fun add() {
        group {
            region()
            assertIs<Region>(children.single())
        }
    }
}
