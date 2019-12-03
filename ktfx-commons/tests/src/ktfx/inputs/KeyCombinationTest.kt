package ktfx.inputs

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCombination
import kotlin.test.Test
import kotlin.test.assertEquals

class KeyCombinationTest {

    @Test fun plus() {
        val charCombination = KeyCombination.SHIFT_DOWN + "x"
        assertEquals("x", charCombination.character)
        assertEquals(KeyCombination.ModifierValue.DOWN, charCombination.shift)

        val codeCombination1 = KeyCombination.ALT_DOWN + KeyCode.F
        assertEquals(KeyCode.F, codeCombination1.code)
        assertEquals(KeyCombination.ModifierValue.DOWN, codeCombination1.alt)

        val codeCombination2 = KeyCode.J + KeyCombination.CONTROL_DOWN
        assertEquals(KeyCode.J, codeCombination2.code)
        assertEquals(KeyCombination.ModifierValue.DOWN, codeCombination2.control)
    }
}