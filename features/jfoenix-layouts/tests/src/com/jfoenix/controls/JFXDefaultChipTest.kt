package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class JFXDefaultChipTest : LayoutsTest<NodeManager, JFXDefaultChip<String>>() {
    private lateinit var jfxChipView: JFXChipView<String>

    override fun onCreate() {
        super.onCreate()
        jfxChipView = JFXChipView()
    }

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxDefaultChip(jfxChipView, "Yo") { }
    override fun NodeManager.child2() = jfxDefaultChip(jfxChipView, "Yo")
    override fun NodeManager.child3() = jfxDefaultChip(jfxChipView, "Yo") { }

    override fun JFXDefaultChip<String>.testDefaultValues() {
        assertEquals(jfxChipView, chipView)
        assertEquals("Yo", item)
    }
}