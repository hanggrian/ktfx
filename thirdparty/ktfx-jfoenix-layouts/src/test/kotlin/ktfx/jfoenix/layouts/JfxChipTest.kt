package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxChipTest : LayoutsStyledTest<KtfxPane, JFXChip<String>>() {
    private lateinit var jfxChipView: JFXChipView<String>

    override fun onCreate() {
        super.onCreate()
        jfxChipView = JFXChipView()
    }

    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxChip(jfxChipView, "Yo") {}

    override fun KtfxPane.child2() = jfxChip(jfxChipView, "Yo")

    override fun child3() = styledJfxChip(jfxChipView, "Yo", styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxChip(jfxChipView, "Yo", styleClass = arrayOf("style"))

    override fun JFXChip<String>.testDefaultValues() {
        assertEquals(jfxChipView, chipView)
        assertEquals("Yo", item)
    }
}
