package ktfx.layouts

import javafx.scene.control.Spinner
import com.hendraanggrian.ktfx.test.LayoutsTest

class SpinnerTest : LayoutsTest<KtfxPane, Spinner<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = spinner<String> { }
    override fun KtfxPane.child2() = spinner<String>()
    override fun KtfxPane.child3() = spinner<String> { }
}
