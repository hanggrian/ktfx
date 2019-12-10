package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class JFXChipTest : LayoutTest<NodeManager, JFXChip<String>>() {
    private lateinit var jfxChipView: JFXChipView<String>

    override fun onCreate() {
        super.onCreate()
        jfxChipView = JFXChipView()
    }

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxChip(jfxChipView, "Yo") { }
    override fun NodeManager.child2() = jfxChip(jfxChipView, "Yo")
    override fun NodeManager.child3() = jfxChip(jfxChipView, "Yo") { }

    override fun JFXChip<String>.testDefaultValues() {
        assertEquals(jfxChipView, chipView)
        assertEquals("Yo", item)
    }
}