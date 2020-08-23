package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class JFXDefaultChipTest : LayoutsTest<KtfxPane, JFXDefaultChip<String>>() {
    private lateinit var jfxChipView: JFXChipView<String>

    override fun onCreate() {
        super.onCreate()
        jfxChipView = JFXChipView()
    }

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxDefaultChip(jfxChipView, "Yo") { }
    override fun KtfxPane.child2() = jfxDefaultChip(jfxChipView, "Yo")
    override fun KtfxPane.child3() = jfxDefaultChip(jfxChipView, "Yo") { }

    override fun JFXDefaultChip<String>.testDefaultValues() {
        assertEquals(jfxChipView, chipView)
        assertEquals("Yo", item)
    }
}