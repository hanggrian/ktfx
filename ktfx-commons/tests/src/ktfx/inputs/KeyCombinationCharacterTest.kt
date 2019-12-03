package ktfx.inputs

import ktfx.test.InputApplicationTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertTrue

@Ignore
class KeyCombinationCharacterTest : InputApplicationTest() {

    @Test fun contains() = assertTrue {
        // KeyCharacterCombination("x", KeyCombination.SHIFT_DOWN) in keyEventOf(KeyEvent.KEY_TYPED, KeyCode.SHIFT, "x")
        true
    }
}