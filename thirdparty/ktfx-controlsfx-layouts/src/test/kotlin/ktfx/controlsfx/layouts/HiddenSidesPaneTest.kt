package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import org.controlsfx.control.HiddenSidesPane
import kotlin.test.Test
import kotlin.test.assertIs

class HiddenSidesPaneTest : LayoutsStyledTest<KtfxPane, HiddenSidesPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = hiddenSidesPane {}

    override fun KtfxPane.child2() = hiddenSidesPane()

    override fun child3() = styledHiddenSidesPane()

    override fun KtfxPane.child4() = styledHiddenSidesPane()

    @Test
    fun add() {
        hiddenSidesPane {
            region()
            assertIs<Region>(content)
        }
    }
}
