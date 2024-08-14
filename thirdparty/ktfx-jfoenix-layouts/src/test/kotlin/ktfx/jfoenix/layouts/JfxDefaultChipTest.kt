package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxDefaultChipTest : LayoutsStyledTest<KtfxPane, JFXDefaultChip<String>>() {
    private lateinit var jfxChipView: JFXChipView<String>

    override fun onCreate() {
        super.onCreate()
        jfxChipView = JFXChipView()
    }

    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxDefaultChip(jfxChipView, "Yo") {}

    override fun KtfxPane.child2() = jfxDefaultChip(jfxChipView, "Yo")

    override fun child3() = styledJfxDefaultChip(jfxChipView, "Yo", styleClass = arrayOf("style"))

    override fun KtfxPane.child4() =
        styledJfxDefaultChip(jfxChipView, "Yo", styleClass = arrayOf("style"))

    override fun JFXDefaultChip<String>.testDefaultValues() {
        assertEquals(jfxChipView, chipView)
        assertEquals("Yo", item)
    }
}
