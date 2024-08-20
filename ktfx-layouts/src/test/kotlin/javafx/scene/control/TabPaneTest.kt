package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Label
import javafx.scene.control.TabPane
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class TabPaneTest : LayoutsStyledTest<KtfxPane, TabPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = tabPane {}

    override fun KtfxPane.child2() = tabPane()

    override fun child3() = styledTabPane()

    override fun KtfxPane.child4() = styledTabPane()

    @Test
    fun stringInvocation() {
        tabPane {
            "World" {
                content = Label()
                assertIs<Label>(content)
            }
            assertEquals(1, tabs.size)
        }
    }
}
