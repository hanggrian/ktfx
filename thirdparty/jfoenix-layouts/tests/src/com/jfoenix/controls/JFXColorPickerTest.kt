package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXColorPicker
import javafx.scene.paint.Color
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class JFXColorPickerTest : LayoutsTest<KtfxPane, JFXColorPicker>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxColorPicker { }
    override fun KtfxPane.child2() = jfxColorPicker()
    override fun KtfxPane.child3() = jfxColorPicker { }

    override fun JFXColorPicker.testDefaultValues() {
        assertEquals(Color.WHITE, value)
    }
}