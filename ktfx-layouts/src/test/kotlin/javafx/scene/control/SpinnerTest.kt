package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Spinner

class SpinnerTest : LayoutsTest<KtfxPane, Spinner<String>>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): Spinner<String> = spinner { }
    override fun KtfxPane.child2(): Spinner<String> = spinner()
    override fun KtfxPane.child3(): Spinner<String> = spinner { }
}
