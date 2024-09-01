package ktfx.controls

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleGroup
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ToggleGroupTest {
    private lateinit var button: RadioButton
    private lateinit var group: ToggleGroup

    @BeforeTest
    fun start() {
        initToolkit()
        button = RadioButton()
        group = ToggleGroup()
        group.toggles += button
    }

    @Test
    fun isSelected() {
        assertFalse(group.isSelected())
        button.isSelected = true
        assertTrue(group.isSelected())
    }

    @Test
    fun isNotSelected() {
        assertTrue(group.isNotSelected())
        button.isSelected = true
        assertFalse(group.isNotSelected())
    }

    @Test
    fun selectedBinding() {
        val binding = group.selectedBinding
        assertFalse(binding.value)
        button.isSelected = true
        assertTrue(binding.value)
    }

    @Test
    fun notSelectedBinding() {
        val binding = group.notSelectedBinding
        assertTrue(binding.value)
        button.isSelected = true
        assertFalse(binding.value)
    }

    @Test
    fun selectedIndex() {
        assertEquals(-1, group.selectedIndex)
        button.isSelected = true
        assertEquals(0, group.selectedIndex)
    }

    @Test
    fun selectIndex() {
        assertFalse(button.isSelected)
        group.selectIndex(0)
        assertTrue(button.isSelected)
    }
}
