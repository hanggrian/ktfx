package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class JFXChipTest : LayoutsTest<KtfxPane, JFXChip<String>>() {
    private lateinit var jfxChipView: JFXChipView<String>

    override fun onCreate() {
        super.onCreate()
        jfxChipView = JFXChipView()
    }

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxChip(jfxChipView, "Yo") { }
    override fun KtfxPane.child2() = jfxChip(jfxChipView, "Yo")
    override fun KtfxPane.child3() = jfxChip(jfxChipView, "Yo") { }

    override fun JFXChip<String>.testDefaultValues() {
        assertEquals(jfxChipView, chipView)
        assertEquals("Yo", item)
    }
}
