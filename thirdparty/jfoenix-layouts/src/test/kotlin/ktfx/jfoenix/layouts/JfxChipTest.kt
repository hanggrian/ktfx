package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxChipTest : LayoutsTest<KtfxPane, JFXChip<String>>() {
    private lateinit var jfxChipView: JFXChipView<String>

    override fun onCreate() {
        super.onCreate()
        jfxChipView = JFXChipView()
    }

    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXChip<String> = jfxChip(jfxChipView, "Yo") { }

    override fun KtfxPane.child2(): JFXChip<String> = jfxChip(jfxChipView, "Yo")

    override fun KtfxPane.child3(): JFXChip<String> = jfxChip(jfxChipView, "Yo") { }

    override fun JFXChip<String>.testDefaultValues() {
        assertEquals(jfxChipView, chipView)
        assertEquals("Yo", item)
    }
}
