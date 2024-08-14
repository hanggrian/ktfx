package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.TitledPane
import kotlin.test.assertNull

class TitledPaneTest : LayoutsStyledTest<KtfxAccordion, TitledPane>() {
    override fun manager() = KtfxAccordion()

    override fun KtfxAccordion.childCount() = panes.size

    override fun child1() = titledPane {}

    override fun KtfxAccordion.child2() = titledPane()

    override fun child3() = styledTitledPane(styleClass = arrayOf("style"))

    override fun KtfxAccordion.child4() = styledTitledPane(styleClass = arrayOf("style"))

    override fun TitledPane.testDefaultValues() {
        assertNull(text)
    }
}
