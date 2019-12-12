package ktfx.inputs

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import kotlin.test.Test
import kotlin.test.assertTrue

class KeyEventTest : BaseInputTest() {

    @Test fun isDelete() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.DELETE).isDelete())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.BACK_SPACE).isDelete())
    }

    @Test fun is0() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD0).is0())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_0).is0())
    }

    @Test fun is1() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD1).is1())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_1).is1())
    }

    @Test fun is2() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD2).is2())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_2).is2())
    }

    @Test fun is3() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD3).is3())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_3).is3())
    }

    @Test fun is4() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD4).is4())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_4).is4())
    }

    @Test fun is5() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD5).is5())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_5).is5())
    }

    @Test fun is6() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD6).is6())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_6).is6())
    }

    @Test fun is7() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD7).is7())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_7).is7())
    }

    @Test fun is8() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD8).is8())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_8).is8())
    }

    @Test fun is9() {
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.NUMPAD9).is9())
        assertTrue(keyEventOf(KeyEvent.KEY_PRESSED, KeyCode.SOFTKEY_9).is9())
    }
}