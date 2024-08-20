package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Spinner

class SpinnerTest : LayoutsStyledTest<KtfxPane, Spinner<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = spinner<String> {}

    override fun KtfxPane.child2() = spinner<String>()

    override fun child3() = styledSpinner<String>()

    override fun KtfxPane.child4() = styledSpinner<String>()
}
