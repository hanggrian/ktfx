package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxDefaultChipTest : LayoutsTest<KtfxPane, JFXDefaultChip<String>>() {
    private lateinit var jfxChipView: JFXChipView<String>

    override fun onCreate() {
        super.onCreate()
        jfxChipView = JFXChipView()
    }

    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXDefaultChip<String> = jfxDefaultChip(jfxChipView, "Yo") { }

    override fun KtfxPane.child2(): JFXDefaultChip<String> = jfxDefaultChip(jfxChipView, "Yo")

    override fun KtfxPane.child3(): JFXDefaultChip<String> = jfxDefaultChip(jfxChipView, "Yo") { }

    override fun JFXDefaultChip<String>.testDefaultValues() {
        assertEquals(jfxChipView, chipView)
        assertEquals("Yo", item)
    }
}
