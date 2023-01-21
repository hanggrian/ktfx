package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import ktfx.layouts.KtfxPane
import kotlin.test.assertEquals

class JfxColorPickerTest : LayoutsTest<KtfxPane, JFXColorPicker>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): JFXColorPicker = jfxColorPicker { }
    override fun KtfxPane.child2(): JFXColorPicker = jfxColorPicker()
    override fun KtfxPane.child3(): JFXColorPicker = jfxColorPicker { }

    override fun JFXColorPicker.testDefaultValues() {
        assertEquals(Color.WHITE, value)
    }
}
