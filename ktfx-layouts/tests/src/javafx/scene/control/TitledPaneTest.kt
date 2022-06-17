package ktfx.layouts

import javafx.scene.control.TitledPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class TitledPaneTest : LayoutsTest<KtfxAccordion, TitledPane>() {

    override fun manager() = KtfxAccordion()
    override fun KtfxAccordion.childCount() = panes.size
    override fun child1() = titledPane { }
    override fun KtfxAccordion.child2() = titledPane()
    override fun KtfxAccordion.child3() = titledPane { }

    override fun TitledPane.testDefaultValues() {
        assertNull(text)
    }
}
